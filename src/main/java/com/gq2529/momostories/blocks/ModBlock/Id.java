package com.gq2529.momostories.blocks.ModBlock;
import com.gq2529.momostories.blocks.BlockBase;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class Id extends BlockBase
{
    public Id(String name, Material material)
    {
        super(name,material);
        setUnlocalizedName(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
        setHardness(20);
        setResistance(6000000);
        setLightLevel(0.8F);
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.ID_QUARTZ;
    }


}
