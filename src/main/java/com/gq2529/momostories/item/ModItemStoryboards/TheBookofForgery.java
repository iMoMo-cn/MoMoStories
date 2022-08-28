package com.gq2529.momostories.item.ModItemStoryboards;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.sun.jna.platform.win32.WinNT;
import jdk.internal.org.objectweb.asm.Handle;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import java.util.List;

//赝造之书
public class TheBookofForgery extends CardBase {
    public TheBookofForgery(String name) {
        super(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(ModCreativeTab.TAB_NAME_1);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if (!world.isRemote)
        {
            if (player.getHeldItemMainhand().getItem() == ModItems.THE_BOOK_OF_FORGERY)
            {
                if (player.isSneaking()) {
                    ItemStack item = player.getHeldItem(hand);
                    item.setCount(item.getCount() - 1);
                    player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.REPLICA_1));
                    player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 5 * 20);
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
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
            tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.the_book_of_forgery").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
