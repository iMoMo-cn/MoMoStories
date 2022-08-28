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

public class AlchemistMedal extends CardBase {
    public AlchemistMedal(String name) {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
    }
    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote)
        {
            if (this == ModItems.ALCHEMIST_MEDALl) {
                if (worldIn.getBlockState(pos).getBlock() == Blocks.IRON_ORE) {
                    player.entityDropItem(new ItemStack(ModItems.IRON_POWDER, 2), 0);
                    worldIn.setBlockState(pos, Blocks.STONE.getDefaultState());
                    return EnumActionResult.SUCCESS;
                } else if (worldIn.getBlockState(pos).getBlock() == Blocks.GOLD_ORE) {
                    player.entityDropItem(new ItemStack(ModItems.GOLD_POWDER, 2), 0);
                    worldIn.setBlockState(pos, Blocks.STONE.getDefaultState());
                    return EnumActionResult.SUCCESS;
                } else if (worldIn.getBlockState(pos).getBlock() == Blocks.DIAMOND_ORE) {
                    player.entityDropItem(new ItemStack(ModItems.GOLD_POWDER, 2), 0);
                    worldIn.setBlockState(pos, Blocks.STONE.getDefaultState());
                    return EnumActionResult.SUCCESS;
                }else if (worldIn.getBlockState(pos).getBlock()  == Blocks.STONE ) {
                    player.entityDropItem(new ItemStack(ModItems.STONE_POWDER, 2), 0);
                    worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                    return EnumActionResult.SUCCESS;
                }
            }
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.alchemist_medal").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
