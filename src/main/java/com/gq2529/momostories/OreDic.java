package com.gq2529.momostories;

import com.gq2529.momostories.blocks.ModBlocks;
import com.gq2529.momostories.item.ModItems;
import net.minecraftforge.oredict.OreDictionary;

public class OreDic {
    public static void init(){
        OreDictionary.registerOre("id", ModBlocks.ID);
        OreDictionary.registerOre("dustStone", ModItems.STONE_POWDER);
        OreDictionary.registerOre("dustIron", ModItems.IRON_POWDER);
        OreDictionary.registerOre("dustGold", ModItems.GOLD_POWDER);



    }
}
