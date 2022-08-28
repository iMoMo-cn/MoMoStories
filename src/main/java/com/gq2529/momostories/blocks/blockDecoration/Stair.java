package com.gq2529.momostories.blocks.blockDecoration;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.blocks.ModBlocks;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Stair extends BlockStairs implements IHasModel {
    public Stair(String name, Block modelBlock) {
        super(modelBlock.getDefaultState());
        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        useNeighborBrightness = true;
    }

    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
