package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItemStoryboards.ModODF.IJumpBoost;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import java.util.List;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//天使计划
public class TheAngelProject extends CardBase implements IJumpBoost {
    public TheAngelProject(String name) {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
    }
    @Override
    public float getJumpBoost() {
        return 0.3F;
    }

    @SubscribeEvent
    public static void onJump(LivingEvent.LivingJumpEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            if (event.getEntityLiving() instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) event.getEntityLiving();
                for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() instanceof IJumpBoost) {
                        IJumpBoost jumpBoost = (IJumpBoost) (itemStack.getItem());
                        player.motionY += jumpBoost.getJumpBoost();
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public static void fist(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.THE_ANGERL_PROJECT) {
                        if (Player.getHeldItemMainhand().isEmpty()) {
                            event.setAmount(event.getAmount() + 10);
                        }
                        Player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2 * 20, 2, false, false));
                        if (0.25 > Math.random())
                        {
                            Player.heal(2f);
                        }
                    }
                }
            }
        }
    }
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            EntityPlayer Player = (EntityPlayer) entityIn;
            if (this == ModItems.THE_ANGERL_PROJECT) {
                if (worldIn.getWorldTime() % 800  == 0)
                    Player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 8 * 20, 2, false, false));
            }
           /* for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                ItemStack itemStack = Player.inventory.getStackInSlot(i);
                if (itemStack.getItem() == ModItems.ESTES) {
                    itemStack.shrink(1);
                    Player.sendMessage(new TextComponentTranslation("EstesText1"));
                }
                if (itemStack.getItem() == ModItems.THE_SUPREME_MAGI_DEEPLAKE) {
                    itemStack.shrink(1);
                    Player.sendMessage(new TextComponentTranslation("TheSupremeMagiDeepLakeText1"));
                }

            }*/
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }
    //工具文本
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        //shift文本显示
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            //第一行，以此类推
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.the_angel_project").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
