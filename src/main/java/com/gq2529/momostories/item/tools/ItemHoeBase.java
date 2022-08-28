package com.gq2529.momostories.item.tools;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class ItemHoeBase extends ItemHoe implements IHasModel
{
    public ItemHoeBase(String name, Item.ToolMaterial material, CreativeTabs creativeTabs)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        ModItems.ITEMS.add(this);
        setCreativeTab(creativeTabs);
    }

    @Override
    public void registerModels()
    {
        MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
