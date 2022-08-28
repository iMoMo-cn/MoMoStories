package com.gq2529.momostories.item.ModItemStoryboards;

import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//强制征兵令
public class ConscriptionOrder extends CardBase {
    public ConscriptionOrder(String name) {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if(!world.isRemote){
            if(player.getHeldItemMainhand().getItem() == this) {
                Entity IronGolem = new EntityIronGolem(world);
                IronGolem.setPosition(player.posX,player.motionY + 5,player.lastTickPosZ);
                world.spawnEntity(IronGolem);
               /* if (0.5 >Math.random())
                { }*/
                player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(),20 * 20 );
            }
        }
        return super.onItemRightClick(world, player, hand);
    }
    @SubscribeEvent
    public static void conscriptionOrder(LivingHurtEvent event){
        World world = event.getEntity().world;
        if (!world.isRemote)
        {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.CONSCRIPTION_ORDER) {

                            hurt.addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 4,false,false));


                    }
                }
            }
        }
    }

    //工具文本
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        //shift文本显示
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            //第一行，以此类推
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.the_supreme").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
