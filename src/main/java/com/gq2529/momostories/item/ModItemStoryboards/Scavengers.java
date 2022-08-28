package com.gq2529.momostories.item.ModItemStoryboards;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)

public class Scavengers extends CardBase {
    public Scavengers(String name) {
        super(name);
        setUnlocalizedName(name);
        setContainerItem(this);
        setCreativeTab(ModCreativeTab.TAB_NAME);
    }
@SubscribeEvent
    public static void scavengers(LivingEvent.LivingUpdateEvent event)
    {
        World world = event.getEntity().world;
        if (!world.isRemote)
        {
            EntityLivingBase hurt = event.getEntityLiving();
            if (hurt instanceof EntityPlayer)
            {
                EntityPlayer Player = (EntityPlayer) hurt;
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.SCAVENGERS) {
                        if (Player.isPotionActive(MobEffects.HUNGER))
                        {
                        Player.removePotionEffect(MobEffects.HUNGER);
                        }
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.scavengers").getFormattedText());
        } else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }

}
