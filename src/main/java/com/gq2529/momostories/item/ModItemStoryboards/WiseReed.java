package com.gq2529.momostories.item.ModItemStoryboards;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class WiseReed extends CardBase {
    public WiseReed(String name) {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME);
    }
    @SubscribeEvent
    public static void reed(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase attack = event.getEntityLiving();
            if (attack instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attack;
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.REED) {
                        event.setAmount(event.getAmount() * 1.5F);
                    }
                }
            }
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        EntityPlayer Player = (EntityPlayer) entityIn;
        if (!worldIn.isRemote)
        {
            if (this == ModItems.WISEREED)
            {
                if (worldIn.getWorldTime() % 20 == 5)
                {
                    Player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION,5 * 20,0));
                    if (Player.getHealth() < 5)
                    {
                        Player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION,2 * 20,4));
                    }
                }

            }
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            tooltip.add(TextFormatting.YELLOW + new TextComponentTranslation("tooltip.wisereed_1").getFormattedText());
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.wisereed_2").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
