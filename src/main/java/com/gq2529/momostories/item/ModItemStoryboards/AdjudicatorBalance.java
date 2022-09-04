package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
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
                Block block = world.getBlockState(pos).getBlock();

                if (block == Blocks.GOLD_ORE)
                {
                    SetBlock(world, pos, Blocks.DIAMOND_ORE);
                }
               else if (block == Blocks.IRON_ORE)
                {
                    SetBlock(world, pos, Blocks.REDSTONE_ORE);
                }
                else if (block == Blocks.STONE)
                {
                    Cooldown(player, hand, 20);
                    SetBlock(world, pos, Blocks.IRON_ORE);
                }
                else if (block == Blocks.COAL_ORE)
                {
                    Random r = new Random();
                    int num = r.nextInt(10) + 1;

                    SetBlock(world, pos, num <= 2 ? Blocks.DIAMOND_ORE : Blocks.STONE);
                }
                else  if (block == Blocks.COAL_BLOCK)
                {
                    Cooldown(player, hand, 40);
                    SetBlock(world, pos, Blocks.DIAMOND_ORE);
                }
            }
        }
        return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
    }

    public EnumActionResult SetBlock(World worldIn, BlockPos pos, Block block)
    {
        worldIn.setBlockState(pos, block.getDefaultState());

        return EnumActionResult.SUCCESS;
    }

    public void Cooldown(EntityPlayer player, EnumHand hand, int time)
    {
        player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), time);
    }

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





