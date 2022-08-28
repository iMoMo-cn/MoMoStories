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
import java.util.Random;


@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//灵魂木偶
public class SoulPuppets extends CardBase
{
    public SoulPuppets(String name)
    {
        super(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);

    }
    @SubscribeEvent
    public static void SoulPuppet(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                    if (Player.getHeldItemOffhand().getItem() == ModItems.SOUL_PUPPETS) {
                        Random r = new Random();
                        int num = r.nextInt(3) + 1;
                        if (num == 1) {
                            //瘫痪
                            hurt.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 255));
                            hurt.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 200, 255));
                            hurt.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 200, 20));
                            Player.getCooldownTracker().setCooldown(Player.getHeldItemOffhand().getItem(),5 * 20 );
                        }
                        if (num == 2) {
                            //替换
                            Player.heal(2f);
                            Player.getCooldownTracker().setCooldown(Player.getHeldItemOffhand().getItem(),5 * 20 );
                        }
                        if (num == 3) {
                            //磨损
                            hurt.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 1, false, false));
                            Player.getCooldownTracker().setCooldown(Player.getHeldItemOffhand().getItem(),5 * 20 );
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
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.soul_puppets").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
