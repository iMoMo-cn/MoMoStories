package com.gq2529.momostories.item.ModItemStoryboards;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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


public class DayTime extends CardBase
{

    static String key;
    public DayTime(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME);
        setMaxStackSize(1);
        setContainerItem(this);
    }

    //检查时间是否为夜晚，是，把时间改为日出；不是，则不执行
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand)
    {
        //判断物品和服务端
        if (this == ModItems.DAYTIME && !world.isRemote)
        {
            //世界时间+1天，方便计算
            final long time = world.getWorldTime() + 24000L;

            //11600为开始日落,12750为雨天夜晚生怪第一刻，
            //22850为晴天夜晚生怪最后一刻，23000为雨天夜晚生怪最后一刻
            //自行选择时间节点

            //判断是否为黑夜
            if (time % 24000L > 11600L && time % 24000L < 23250L)
            {
                //是，时间调至日出
                world.setWorldTime(time - time % 24000L - 450);
                player.sendMessage(new TextComponentTranslation("DayTimeText"));
                player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 100, 3));

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
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.daytime_2").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
