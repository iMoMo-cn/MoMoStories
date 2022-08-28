package com.gq2529.momostories.potion.effect.ModEffect;
import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.potion.effect.PotionBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

import static com.gq2529.momostories.potion.effect.ModPotions.IDEALLAND;


public class idealland extends PotionBase {
    public ResourceLocation TEXTURE = new ResourceLocation(MoMoFramework.MODID, "textures/gui/heavy_armor.png");


    public idealland(String name, boolean isBadEffect, int color, int icon) {
        super(name, isBadEffect, color, icon);
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
        EntityPlayer o = (EntityPlayer) entityLivingBaseIn;
        if (this == IDEALLAND)
        {
            o.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 255));//缓慢
            o.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 200, 2));//吸收
            o.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 4));//回血

        }
    }
}


