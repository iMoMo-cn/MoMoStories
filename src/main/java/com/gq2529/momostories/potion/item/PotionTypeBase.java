package com.gq2529.momostories.potion.item;

import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;

import javax.annotation.Nullable;

public class PotionTypeBase extends PotionType {
    public PotionTypeBase(@Nullable String name, PotionEffect... potionEffects)
    {
        super(name, potionEffects);

        ModPotionTypes.POTION_TYPES.add(this);
    }
}
