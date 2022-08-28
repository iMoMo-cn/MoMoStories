package com.gq2529.momostories.item.ModItemStoryboards;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

//太阳神教
public class ChurchoftheSunGod extends CardBase
{
    static String key;
    public ChurchoftheSunGod(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
        setMaxStackSize(1);
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
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.church_of_the_sun_god_2").getFormattedText());
        } else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
