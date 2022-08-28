package com.gq2529.momostories.init;

import com.gq2529.momostories.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModCreativeTab {
   public static final CreativeTabs TAB_NAME = new CreativeTabs(CreativeTabs.getNextID(), "momo_stories_nature")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return new ItemStack(ModItems.DAYTIME); }
   };
    public static final CreativeTabs TAB_NAME_1 = new CreativeTabs(CreativeTabs.getNextID(), "momo_stories_mysterious")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return new ItemStack(ModItems.FRAUDULENT_BOTTLES); }
    };
    public static final CreativeTabs TAB_NAME_2 = new CreativeTabs(CreativeTabs.getNextID(), "momo_stories_interference")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return new ItemStack(ModItems.ADJUDICATOR_BALANCE); }
    };
    public static final CreativeTabs TAB_NAME_4 = new CreativeTabs(CreativeTabs.getNextID(), "momo_stories_implement")
    {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() { return new ItemStack(ModItems.THE_FRUIT_OF_THE_FLOWING_YEARS); }
    };

}
