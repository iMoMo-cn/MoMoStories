package com.gq2529.momostories.item.tools;

import com.gq2529.momostories.item.tools.Replica.Timemanagement;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Timingtime extends Item {



    @Override

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged){

        if(!oldStack.isEmpty() || !newStack.isEmpty()){
            if(oldStack.getItem() == newStack.getItem() && !slotChanged) return false;
        }

        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
    }
    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        int damage = stack.getItemDamage();
        if (world.getWorldTime() % 20 == 0) {
            if (damage > stack.getMaxDamage())
                Timemanagement.replaceItemInInventory(entity, slot, stack, ItemStack.EMPTY);
            stack.setItemDamage(damage + 1);
        }
    }
}
