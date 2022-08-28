package com.gq2529.momostories.potion.effect.ModEffect;

import com.gq2529.momostories.potion.effect.PotionBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class Slowfall extends PotionBase
{
    public Slowfall(String name, boolean isBadEffect, int color, int icon)
    {
        super(name, isBadEffect, color, icon);
    }
@Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
        EntityPlayer Player = (EntityPlayer) entityLivingBaseIn;
        if (!Player.onGround && Player.motionY < 0.0D)
        {
            Player.motionY *= 0.6D;
            Player.fallDistance = 0f;
        }
    }
}
