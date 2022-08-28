package com.gq2529.momostories.blocks.blockDecoration;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.blocks.ModBlocks;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class Fence extends BlockFence implements IHasModel {

    public Fence(String name, Material materialIn, MapColor mapColorIn) {
            super(materialIn, mapColorIn);
            this.setRegistryName(name);
            this.setUnlocalizedName(name);
            setHardness(2.0F);
            setResistance(5.0F);

            ModBlocks.BLOCKS.add(this);
            ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        }

        @Override
        public void registerModels() {
            MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
        }
}
