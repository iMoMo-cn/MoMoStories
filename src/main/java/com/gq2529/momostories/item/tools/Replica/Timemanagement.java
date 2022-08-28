package com.gq2529.momostories.item.tools.Replica;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.EntityEquipmentSlot.Type;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.NonNullList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Timemanagement {

	private Timemanagement(){} // No instances!

	private static final EntityEquipmentSlot[] ARMOUR_SLOTS;

	static {
		List<EntityEquipmentSlot> slots = new ArrayList<>(Arrays.asList(EntityEquipmentSlot.values()));
		slots.removeIf(slot -> slot.getSlotType() != Type.ARMOR);
		ARMOUR_SLOTS = slots.toArray(new EntityEquipmentSlot[0]);
	}

	private static List<ItemStack> getHotbar(EntityPlayer player){
		NonNullList<ItemStack> hotbar = NonNullList.create();
		hotbar.addAll(player.inventory.mainInventory.subList(0, 9));
		return hotbar;
	}

	public static List<ItemStack> getPrioritisedHotbarAndOffhand(EntityPlayer player){
		List<ItemStack> hotbar = getHotbar(player);
		// Adds the offhand item to the beginning of the list so it is processed before the hotbar
		hotbar.add(0, player.getHeldItemOffhand());
		// Moves the item in the main hand to the beginning of the list so it is processed first
		hotbar.remove(player.getHeldItemMainhand());
		hotbar.add(0, player.getHeldItemMainhand());
		return hotbar;
	}

	public static EnumHandSide getSideForHand(EntityLivingBase entity, EnumHand hand){
		return hand == EnumHand.MAIN_HAND ? entity.getPrimaryHand() : entity.getPrimaryHand().opposite();
	}

	public static EnumHand getHandForSide(EntityLivingBase entity, EnumHandSide side){
		return side == entity.getPrimaryHand() ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND;
	}
	public static EnumHand getOpposite(EnumHand hand){
		return hand == EnumHand.OFF_HAND ? EnumHand.MAIN_HAND : EnumHand.OFF_HAND;
	}

	public static boolean doesPlayerHaveItem(EntityPlayer player, Item item){

		for(ItemStack stack : player.inventory.mainInventory){
			if(stack.getItem() == item){
				return true;
			}
		}
		for(ItemStack stack : player.inventory.armorInventory){
			if(stack.getItem() == item){
				return true;
			}
		}
		for(ItemStack stack : player.inventory.offHandInventory){
			if(stack.getItem() == item){
				return true;
			}
		}
		return false;
	}
	public static ItemStack copyWithMeta(ItemStack toCopy, int newMetadata){
		ItemStack copy = new ItemStack(toCopy.getItem(), toCopy.getCount(), newMetadata);
		NBTTagCompound compound = toCopy.getTagCompound();
		if(compound != null) copy.setTagCompound(compound.copy());
		return copy;
	}

	public static boolean canMerge(ItemStack stack1, ItemStack stack2){
		return !stack1.isEmpty() && !stack2.isEmpty()
				&& stack1.isStackable() && stack2.isStackable()
				&& stack1.getItem() == stack2.getItem()
				&& (!stack1.getHasSubtypes() || stack1.getMetadata() == stack2.getMetadata())
				&& ItemStack.areItemStackTagsEqual(stack1, stack2);
	}
	public static boolean replaceItemInInventory(Entity entity, int slot, ItemStack original, ItemStack replacement){
		// Check slots that aren't in the main inventory first by comparing with the existing item
		if(entity instanceof EntityLivingBase){
			for(EntityEquipmentSlot eslot : EntityEquipmentSlot.values()){
				if(((EntityLivingBase)entity).getItemStackFromSlot(eslot) == original){
					entity.setItemStackToSlot(eslot, replacement);
					return true;
				}
			}
		}
		return entity.replaceItemInInventory(slot, replacement);
	}

}
