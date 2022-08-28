package com.gq2529.momostories.item.tools.Replica;
import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;


//复制品3稿子
public class Replica_3  extends ItemPickaxe implements IHasModel {
    private static final Item.ToolMaterial BOUNDLESS_MATERIAL = EnumHelper.addToolMaterial("boundless_material", 5, -1, 18.0F, 5, 9);

    public Replica_3(String name)
        {
            super(BOUNDLESS_MATERIAL);
            setUnlocalizedName(name);
            setRegistryName(name);
            setCreativeTab(ModCreativeTab.TAB_NAME_4);
            ModItems.ITEMS.add(this);
    }
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if (!world.isRemote)
        {

            if (player.getHeldItemMainhand().getItem() == ModItems.REPLICA_3)
            {
                if (player.isSneaking()) {
                    ItemStack item = player.getHeldItem(hand);
                    item.setCount(item.getCount() - 1);
                    player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.REPLICA_4));
                    player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 5 * 20);
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void registerModels() {
        {
            MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
        }
    }
}
