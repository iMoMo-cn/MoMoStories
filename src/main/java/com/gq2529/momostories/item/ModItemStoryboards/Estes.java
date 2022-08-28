package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItemStoryboards.ModODF.IJumpBoost;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.potion.effect.ModPotions;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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
public class Estes extends CardBase implements IJumpBoost {
    public Estes(String name) {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
    }
    @Override
    public float getJumpBoost() {
        return 0.2F;
    }

    @SubscribeEvent
    public static void onJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
                ItemStack itemStack = player.inventory.getStackInSlot(i);
                if (itemStack.getItem() instanceof IJumpBoost) {
                    IJumpBoost jumpBoost = (IJumpBoost) (itemStack.getItem());
                    player.motionY += jumpBoost.getJumpBoost();
                }
            }
        }
    }
    //BUFF
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            EntityPlayer Player = (EntityPlayer) entityIn;
            if (this == ModItems.ESTES) {
                Player.addPotionEffect(new PotionEffect(ModPotions.DEMONESSENCE, 20));
                if (!Player.onGround && Player.motionY < 0.0D)
                {
                    Player.fallDistance = 0f;
                }
            }
            for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                ItemStack itemStack = Player.inventory.getStackInSlot(i);
                if (itemStack.getItem() == ModItems.THE_ANGERL_PROJECT) {
                    itemStack.shrink(1);
                    Player.sendMessage(new TextComponentTranslation("EstesText1"));
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
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.estes").getFormattedText());
        } else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }

}
