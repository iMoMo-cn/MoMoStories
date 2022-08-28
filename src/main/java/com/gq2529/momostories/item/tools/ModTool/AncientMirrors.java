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

//古镜
public class AncientMirrors extends CardBase
{
    public AncientMirrors(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
    }
    //复制物品
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand)
    {
        if (!world.isRemote)
        {
            if (this == ModItems.ANCIENT_MIRRORS)
            {
                //获取副手物品
                ItemStack a = player.getHeldItemOffhand();
                ItemStack item = player.getHeldItem(hand);
                //复制
                ItemStack B = a.copy();
                //掉落物形式
                world.spawnEntity(new EntityItem(world,player.posX,player.posY,player.posZ,B));
                item.setCount(item.getCount() - 1);

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
