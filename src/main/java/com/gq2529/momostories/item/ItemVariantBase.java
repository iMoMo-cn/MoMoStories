package com.gq2529.momostories.item;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.util.IHasModel;
import com.gq2529.momostories.util.IMetaName;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemVariantBase extends ItemBase implements IHasModel, IMetaName {
    protected int typeCount = 1;

    public ItemVariantBase(String name, int count) {
        super(name);
        this.typeCount = count;
        this.hasSubtypes = true;
    }

    @Override
    public void registerModels()
    {
        for (int i = 0; i < typeCount; i++)
        {
            MoMoFramework.proxy.registerItemRenderer(this, i, "inventory");
        }
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        int i = stack.getMetadata();
        return super.getUnlocalizedName() + "_" + i;
    }


    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            for (int i = 0; i < typeCount; ++i)
            {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return null;
    }
}
