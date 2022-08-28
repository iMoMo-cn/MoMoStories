package com.gq2529.momostories.potion.effect.ModEffect;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.potion.effect.PotionBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HeavyArmor extends PotionBase
{
    private ResourceLocation TEXTURE = new ResourceLocation(MoMoFramework.MODID, "textures/gui/heavy_armor.png");
    //神奇的uuid（作者对这个东西有很大的兴趣）
    private String DAMAGE = "22731EAC-81C4-E099-4091-767776224DDD";
    private String ARMOR = "0F0501F5-DF98-BC14-593E-10FB74CE5ECE";
    private String ARMOR_TOUGHNESS = "05C4C1AC-9ECC-C4B5-3315-818562F53EFC";
    //private String ATTACK_SPEED ="1F16F442-3DAF-A5F1-1CFF-B664B9731F05";

    public HeavyArmor(String name, boolean isBadEffect, int color, int icon)
    {
        super(name, isBadEffect, color, icon);
        setPotionName(MoMoFramework.MODID+".effect.heavy_armor");
        //攻击修改
        registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, DAMAGE, 0.45D, 1);
        //护甲修改
        registerPotionAttributeModifier(SharedMonsterAttributes.ARMOR, ARMOR, 20, 0);
        //护甲韧性修改
        registerPotionAttributeModifier(SharedMonsterAttributes.ARMOR_TOUGHNESS, ARMOR_TOUGHNESS, 20, 0);
        //实验功能
       //registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED,ATTACK_SPEED ,52,0);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc)
    {
        super.renderInventoryEffect(x, y, effect, mc);
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(x+6, y+7, 0, 0, 18, 18, 18, 18);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderHUDEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc, float alpha)
    {
        super.renderHUDEffect(x, y, effect, mc, alpha);
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(x+3, y+3, 0, 0, 18, 18, 18, 18);
    }




}
