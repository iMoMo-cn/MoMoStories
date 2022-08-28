package com.gq2529.momostories.events;


import net.minecraft.util.DamageSource;

public class DamageSource1 extends DamageSource {
    public static final DamageSource TWIST = (new DamageSource1("SDAD"));
    public static final DamageSource THUNDER = (new DamageSource1("thunder"));
    public static final DamageSource TIME = (new DamageSource1("time"));
    public DamageSource1(String damageTypeIn) {
        super(damageTypeIn);
        setDamageIsAbsolute();
        setDamageAllowedInCreativeMode();

    }


}
