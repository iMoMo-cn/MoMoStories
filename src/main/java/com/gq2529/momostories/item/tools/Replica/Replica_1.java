package com.gq2529.momostories.item.tools.Replica;
import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import com.gq2529.momostories.util.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;


@Mod.EventBusSubscriber(modid = Reference.MOD_ID)

//复制品1剑
public class Replica_1 extends ItemSword implements IHasModel {
    private static final Item.ToolMaterial BOUNDLESS_MATERIAL = EnumHelper.addToolMaterial("boundless_material", 5, -1, 8, 4, 9);

    public Replica_1(String name) {
        super(BOUNDLESS_MATERIAL);
        setUnlocalizedName(name);
        setRegistryName(name);
        setMaxStackSize(1);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
        ModItems.ITEMS.add(this);

    }
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if (!world.isRemote)
        {

            if (player.getHeldItemMainhand().getItem() == ModItems.REPLICA_1)
            {
                if (player.isSneaking()) {
                    ItemStack item = player.getHeldItem(hand);
                    item.setCount(item.getCount() - 1);
                    player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.REPLICA_2));
                    player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 5 * 20);
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
    }
    @SubscribeEvent
    public static void replica_1(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                if (Player.getHeldItemMainhand().getItem() == ModItems.REPLICA_1) {
                    hurt.setLocationAndAngles(hurt.posX, Player.posY + 10, hurt.posZ, 4, 6);
                }
            }
        }
    }

    @Override
        public void registerModels() {
            MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
        }

    }

