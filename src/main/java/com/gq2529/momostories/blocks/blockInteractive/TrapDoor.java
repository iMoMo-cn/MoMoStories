package com.gq2529.momostories.blocks.blockInteractive;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.blocks.ModBlocks;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class TrapDoor extends BlockTrapDoor implements IHasModel {

    public TrapDoor(String name, Material materialIn) {
        super(materialIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(3.0F);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this){
                    @Override
                    public int getItemBurnTime(ItemStack itemStack)
                    {
                        return materialIn == Material.WOOD? 300:-1;
                    }
                }.setRegistryName(this.getRegistryName())
        );
    }

    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
