package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import java.util.List;
public class Fine extends CardBase
{
    static String key;
    public Fine(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME);
        setMaxStackSize(1);
        setContainerItem(this);
    }
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand)
    {
        if (this == ModItems.FINE && !world.isRemote)
        {
            if (world.isRaining())
            {
                world.getWorldInfo().setRaining(false);
                player.sendMessage(new TextComponentTranslation("FineText"));

            }
        }
        return super.onItemRightClick(world, player, hand);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
       // tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.fine_1").getFormattedText());
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.fine_2").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
