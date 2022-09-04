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
            if (this == ModItems.ALCHEMIST_MEDAL) {

                Block block = worldIn.getBlockState(pos).getBlock();

                if (block == Blocks.IRON_ORE)
                {
                    dropAndSetBlock(worldIn, pos, player, ModItems.IRON_POWDER, Blocks.STONE);
                }
                else if (block == Blocks.GOLD_ORE)
                {
                    dropAndSetBlock(worldIn, pos, player, ModItems.GOLD_POWDER, Blocks.STONE);
                }
                else if (block == Blocks.DIAMOND_ORE) {
                    dropAndSetBlock(worldIn, pos, player, ModItems.GOLD_POWDER, Blocks.STONE);
                }
                else if (block == Blocks.STONE)
                {
                    dropAndSetBlock(worldIn, pos, player, ModItems.STONE_POWDER, Blocks.AIR);
                }
            }
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    public EnumActionResult dropAndSetBlock(World worldIn, BlockPos pos, EntityPlayer player, Item item, Block block)
    {
        player.entityDropItem(new ItemStack(item, 2),0);

        worldIn.setBlockState(pos, block.getDefaultState());

        return EnumActionResult.SUCCESS;
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
