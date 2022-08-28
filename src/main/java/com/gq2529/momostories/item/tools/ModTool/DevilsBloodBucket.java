package com.gq2529.momostories.item.tools.ModTool;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ItemBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
//魔鬼血液桶
public class DevilsBloodBucket extends ItemBase {
    public DevilsBloodBucket(String name) {
        super(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
        setContainerItem(Items.BUCKET);
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack) {
        return 40000;
    }
}
