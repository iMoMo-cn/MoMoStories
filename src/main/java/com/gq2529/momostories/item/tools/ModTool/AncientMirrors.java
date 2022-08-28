package com.gq2529.momostories.item.tools.ModTool;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
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

public class AncientMirrors extends CardBase
{
    public AncientMirrors(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
    }
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand)
    {
        if (!world.isRemote)
        {
            if (this == ModItems.ANCIENT_MIRRORS)
            {
                ItemStack a = player.getHeldItemOffhand();
                ItemStack item = player.getHeldItem(hand);
                ItemStack B = a.copy();
                world.spawnEntity(new EntityItem(world,player.posX,player.posY,player.posZ,B));
                item.setCount(item.getCount() - 1);

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
            tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.ancient_mirrors_1").getFormattedText());
            tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.ancient_mirrors_2").getFormattedText());
            tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.ancient_mirrors_3").getFormattedText());
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.ancient_mirrors_4").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
