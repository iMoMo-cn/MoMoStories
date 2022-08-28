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
import javax.annotation.Nonnull;
import java.util.List;

//具显之书
public class TheBookofManifestation extends CardBase
{
    public TheBookofManifestation(String name)
    {
        super(name);
        setUnlocalizedName(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_1);
        setMaxStackSize(1);
        setContainerItem(this);
    }
    //工作台合成不消耗，返还物品
    @Nonnull
    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        //物品堆叠复制
        ItemStack stack = itemStack.copy();
        stack.setCount(1);
        return stack;

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
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.b_2").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
