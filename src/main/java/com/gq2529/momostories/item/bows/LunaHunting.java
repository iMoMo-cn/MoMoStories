package com.gq2529.momostories.item.bows;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//月神狩猎
public class LunaHunting extends ItemBow implements IHasModel {
    static String key;


    public LunaHunting(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);
        ModItems.ITEMS.add(this);
        setMaxStackSize(1);
        setMaxDamage(-1);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
        addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (entityIn == null) {
                    return 0.0F;
                } else {
                    return entityIn.getActiveItemStack().getItem() != Items.BOW ? 0.0F : (float) (stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 1.0F;
                }
            }
        });
    }



    //框架特有
    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @SubscribeEvent
    public static void luna_hunting(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.LUNA_HUNTING) {
                        if (!world.isDaytime()) {
                            event.setAmount(event.getAmount() * 5);
                        }
                    }
                }
            }
        }
    }
    //晚上不消耗箭矢
    private ItemStack findAmmo(EntityPlayer player) {
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND))) {
            return player.getHeldItem(EnumHand.OFF_HAND);
        } else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND))) {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        } else {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack)) {
                    return itemstack;
                }
            }
            return ItemStack.EMPTY;
        }
    }

    //能看懂看吧，作者这块写的也迷糊
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;

            final long time = worldIn.getWorldTime() + 24000L;

            boolean flagNight = (time % 24000L > 13850L && time % 24000L < 23000L);

            ItemStack itemstack = this.findAmmo(entityplayer);

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag || flagNight);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag || flagNight) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getArrowVelocity(i);

                if ((double) f >= 0.1D) {
                    boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemArrow && ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));

                    if (!worldIn.isRemote) {
                        ItemArrow itemarrow = (ItemArrow) (itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW);
                        EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);

                        if (f == 1.0F) {
                            entityarrow.setIsCritical(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

                        if (j > 0) {
                            entityarrow.setDamage(entityarrow.getDamage() + (double) j * 0.5D + 0.5D);
                        }

                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

                        if (k > 0) {
                            entityarrow.setKnockbackStrength(k);
                        }

                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                            entityarrow.setFire(100);
                        }

                        stack.damageItem(1, entityplayer);

                        if (flagNight || flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
                            entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                        }

                        worldIn.spawnEntity(entityarrow);
                    }

                    worldIn.playSound((EntityPlayer) null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    if (!flag1 && !entityplayer.capabilities.isCreativeMode && !flagNight) {
                        itemstack.shrink(1);

                        if (itemstack.isEmpty()) {
                            entityplayer.inventory.deleteStack(itemstack);
                        }
                    }
                    entityplayer.addStat(StatList.getObjectUseStats(this));
                }
            }
        }
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        //shift文本显示
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            //第一行，以此类推
            tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.luna_hunting_1").getFormattedText());
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.luna_hunting_2").getFormattedText());
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.luna_hunting_3").getFormattedText());
        } else {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}



