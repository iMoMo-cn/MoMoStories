package com.gq2529.momostories.item.tools.ModTool;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.shields.ItemShieldBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import java.util.List;

public class ProofofGloryFalse extends ItemShieldBase  {
    public ProofofGloryFalse(String name) {
        super(name,200);
        setUnlocalizedName(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.proof_of_glory").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
