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
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import java.util.List;

//黑夜
public class Night extends CardBase
{
    public Night(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME);
        setMaxStackSize(1);
        setContainerItem(this);
    }
    //检查时间是否为白天，是，把时间改为夜晚；不是，则不执行
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        //判断物品和服务端
        if (this == ModItems.NIGHT && !world.isRemote) {
            final long time = world.getWorldTime() + 24000L;
            //13000为开始日落最后一刻，月出第一刻
            //22200为日出第一刻，月落最后一刻
            //自行选择时间节点
            //判断是否为白天
            if (time % 24000L < 12750L || time % 24000L > 23250L) {
                //是，时间调至夜晚
                world.setWorldTime(time - time % 24000L + 13750);
                //聊天文本
                player.sendMessage(new TextComponentTranslation("NightText"));
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
        //第一行，以此类推
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
                   tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.night_2").getFormattedText());
        } else
            {
                tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
            }
        }
    }

