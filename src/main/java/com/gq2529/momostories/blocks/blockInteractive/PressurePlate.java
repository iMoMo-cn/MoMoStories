package com.gq2529.momostories.blocks.blockInteractive;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.blocks.ModBlocks;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class PressurePlate extends BlockPressurePlate implements IHasModel {
    public static Sensitivity sensitivity = BlockPressurePlate.Sensitivity.EVERYTHING;

    public PressurePlate(String name, Material materialIn) {
        super(materialIn, sensitivity);

        this.setRegistryName(name);
        this.setUnlocalizedName(name);

        this.setHardness(0.5F);
        this.setSoundType(SoundType.WOOD);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    public PressurePlate setSensitivity(boolean isEverythingActive)
    {
        if(isEverythingActive) { sensitivity = BlockPressurePlate.Sensitivity.EVERYTHING; }
        else { sensitivity = Sensitivity.MOBS; }
        return this;
    }
}

