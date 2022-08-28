package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.lwjgl.input.Keyboard;

import java.util.List;
public class Freshman extends CardBase {
    private ItemStack oldStack;
    private ItemStack newStack;
    private boolean slotChanged;

    public Freshman(String name) {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        if (worldIn.isRemote || !(entityIn instanceof EntityPlayer)) {
            return;
        }
        repairAllItems(worldIn, (EntityPlayer) entityIn);
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 0;
    }

    private void repairAllItems(World worldIn, EntityPlayer player) {
        final IItemHandler inv = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        assert inv != null;
        for (int i = 0; i < inv.getSlots(); i++) {
            final ItemStack invStack = inv.getStackInSlot(i);
            if (invStack.isEmpty() || !invStack.getItem().isRepairable()) {
                continue;
            }
            if (worldIn.getWorldTime() % 20 == 1) {
                if (invStack != player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) && invStack != player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND) || !player.isSwingInProgress) {
                    if (!invStack.getHasSubtypes() && invStack.getMaxDamage() != 0 && invStack.getItemDamage() > 0)
                        invStack.setItemDamage(invStack.getItemDamage() - 1);
                }
            }
        }
    }
    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged){
        this.oldStack = oldStack;
        this.newStack = newStack;
        this.slotChanged = slotChanged;

        if(!oldStack.isEmpty() || !newStack.isEmpty()){
            if(oldStack.getItem() == newStack.getItem() && !slotChanged)

                return false;
        }
        return super.shouldCauseReequipAnimation(oldStack, newStack, slotChanged);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        if (org.lwjgl.input.Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.freshman_4").getFormattedText());
        } else {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}





