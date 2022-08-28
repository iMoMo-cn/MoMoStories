package com.gq2529.momostories.blocks.blockBasic;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.blocks.ModBlocks;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockBurnable extends Block implements IHasModel {
    public BlockBurnable(String name, int burnTime, Material material, MapColor mapColor){
        super(material, mapColor);
        setUnlocalizedName(name);
        setRegistryName(name);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this){
            @Override
            public int getItemBurnTime(ItemStack itemStack)
            {
                return burnTime;
            }
        }.setRegistryName(this.getRegistryName()));
    }

    public BlockBurnable(String name, int burnTime, Material material){
        this(name, burnTime, material, material.getMaterialMapColor());
    }

    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
