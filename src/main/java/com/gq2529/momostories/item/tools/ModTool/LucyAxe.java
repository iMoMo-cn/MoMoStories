package com.gq2529.momostories.item.tools.ModTool;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class LucyAxe extends ItemAxe implements IHasModel
{
    private static final ToolMaterial BOUNDLESS_MATERIAL = EnumHelper.addToolMaterial("boundless_material",5,2000,15,1,9);

    public LucyAxe(String name)
    {
        super(BOUNDLESS_MATERIAL, 2, 1F);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");

    }
    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if (world.isRemote) {
            player.sendStatusMessage(new TextComponentTranslation( "lucy_the_axe." + MathHelper.getInt(itemRand, 1, 30)).setStyle(new Style().setColor(TextFormatting.YELLOW)), true);
            player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 20 );
        }
        return super.onItemRightClick(world, player, hand);
    }
    public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return false;
    }

    public boolean isEnchantable(ItemStack stack) { return false; }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.lucy_the_axe").getFormattedText());
        }


}



