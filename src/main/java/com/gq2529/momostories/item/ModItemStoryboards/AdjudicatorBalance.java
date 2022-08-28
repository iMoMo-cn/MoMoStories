package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import javax.annotation.Nonnull;

import java.util.List;
import java.util.Random;

public class AdjudicatorBalance extends CardBase
{
    private static String key;
    public AdjudicatorBalance(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
        setMaxStackSize(1);
        setContainerItem(this);
    }
    @Nonnull
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setCount(1);
        return stack;

    }
    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!player.world.isRemote)
        {
            if (this == ModItems.ADJUDICATOR_BALANCE)
            {
                if (world.getBlockState(pos).getBlock() == Blocks.GOLD_ORE)
                {
                    world.setBlockState(pos, Blocks.DIAMOND_ORE.getDefaultState());
                    return EnumActionResult.SUCCESS;
                }
               else if (world.getBlockState(pos).getBlock() == Blocks.IRON_ORE)
                {
                    world.setBlockState(pos, Blocks.REDSTONE_ORE.getDefaultState());
                    return EnumActionResult.SUCCESS;
                }
                else if (world.getBlockState(pos).getBlock() ==Blocks.STONE)
            {
                world.setBlockState(pos, Blocks.IRON_ORE.getDefaultState());
                player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 20 );
                return EnumActionResult.SUCCESS;
            }
               else if (world.getBlockState(pos).getBlock() ==Blocks.COAL_ORE)
                {
                    Random r = new Random();
                    int num = r.nextInt(10) + 1;
                    if (num >=1 && num<= 2)
                    {
                        world.setBlockState(pos, Blocks.DIAMOND_ORE.getDefaultState());
                        return EnumActionResult.SUCCESS;
                    }
                  else  if (3<=num&&num<=10)
                    {
                    world.setBlockState(pos, Blocks.STONE.getDefaultState());
                    return EnumActionResult.SUCCESS;
                    }
                }
              else  if (world.getBlockState(pos).getBlock() ==Blocks.COAL_BLOCK)
                {
                    world.setBlockState(pos, Blocks.DIAMOND_ORE.getDefaultState());
                    player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 40 );
                    return EnumActionResult.SUCCESS;
                }
            }
        }
        return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }
    //工具文本
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.adjudicator_balance_4").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}





