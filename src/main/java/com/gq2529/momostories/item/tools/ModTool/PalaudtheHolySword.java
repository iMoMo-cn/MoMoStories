package com.gq2529.momostories.item.tools.ModTool;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.ItemSwordBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
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
//帕劳德圣剑
public class PalaudtheHolySword extends ItemSwordBase {

    private static final ToolMaterial BOUNDLESS_MATERIAL = EnumHelper.addToolMaterial("boundless_material", 5, -1, 8.0F, 8, 9);

    public PalaudtheHolySword(String name) {
        super(name, BOUNDLESS_MATERIAL, ModCreativeTab.TAB_NAME_4);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setContainerItem(this);

    }
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if (!world.isRemote)
        {
            if (player.getHeldItemMainhand().getItem() == ModItems.Palaud_the_Holy_Sword)
            {
                if (player.isSneaking()) {
                    if (player.getHeldItemOffhand().getItem() == Items.SHIELD) {
                        ItemStack item = player.getHeldItemOffhand();
                        item.setCount(item.getCount() - 1);
                        player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(ModItems.Proof_of_glory_false));
                    }
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
    }
    @SubscribeEvent
    public static void PalaudtheHoly(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                if (Player.getHeldItemMainhand().getItem() == ModItems.Palaud_the_Holy_Sword)
                {
                    if (world.isDaytime())
                    {
                        hurt.setFire(30);
                    }
                }
            }
        }
    }
}
