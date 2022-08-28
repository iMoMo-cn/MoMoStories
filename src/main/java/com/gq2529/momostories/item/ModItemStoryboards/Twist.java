package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.events.DamageSource1;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import java.util.List;
import java.util.Random;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class Twist extends CardBase
{
    public Twist(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_1);
        setMaxStackSize(1);
        setContainerItem(this);
    }
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void TWIST(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.TWIST) {
                       if (0.5 >Math.random())
                       {
                           hurt.setHealth(0);
                       }
                        else {
                           attacker.attackEntityFrom(DamageSource1.TWIST, 9999999.0F);
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
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.twist_2").getFormattedText());
        }
             else
            {
                tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
            }
    }
}


