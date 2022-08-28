package com.gq2529.momostories.item.food.ModFood;
import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


import java.util.List;
//肉丸
public class MysteriousMeatballs extends ItemFood implements IHasModel {
    public MysteriousMeatballs(String name) {
        super(6, 1.6f, true);
        setUnlocalizedName(name);
        setRegistryName(name);
        setAlwaysEdible();
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
        ModItems.ITEMS.add(this);

    }
    @Override
    public void registerModels() {
        {
            MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
        }

    }
    //工具文本
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        //第一行，以此类推
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.mysterious_meatballs").getFormattedText());

    }
}
