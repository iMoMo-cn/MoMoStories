package com.gq2529.momostories.item.tools.ModTool;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ItemBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.List;
public class LettertoKerry extends ItemBase {
    public LettertoKerry(String name) {
        super(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
            tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.LettertoKerry").getFormattedText());

    }
}
