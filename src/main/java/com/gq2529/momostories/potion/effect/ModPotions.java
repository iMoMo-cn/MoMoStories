package com.gq2529.momostories.potion.effect;
import com.gq2529.momostories.potion.effect.ModEffect.DemonEssence;
import com.gq2529.momostories.potion.effect.ModEffect.HeavyArmor;
import com.gq2529.momostories.potion.effect.ModEffect.Slowfall;
import com.gq2529.momostories.potion.effect.ModEffect.idealland;
import net.minecraft.potion.Potion;
import java.util.ArrayList;
import java.util.List;

public class ModPotions
{
    public static final List<Potion> POTIONS = new ArrayList<>();
//    public static final Potion NEW_INSTANT_POTION = new InstantPotion("name", false , 0xFFF8DC, 0);
//    public static final Potion NEW_POTION = new PotionBase("name", true, 0x66CCFF, 1);
    public static final Potion IDEALLAND = new idealland("idealland",false,0x66CCFF,0);
    public static final Potion HEAVY_ARMOR = new HeavyArmor("heavy_armor",false,0x66CCFF,0);
    public static final Potion SLOWFALL = new Slowfall("slowfall", false, 0xF46F20,2);

    public static final Potion DEMONESSENCE = new DemonEssence("demonessence", false, 0xF46F20,2);


}
