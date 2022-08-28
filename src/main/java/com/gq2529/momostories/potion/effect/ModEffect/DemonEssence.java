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



//恶魔之粹
public class DemonEssence extends PotionBase {
    private static final String ATTACK_SPEED = "e5fd14f3-8053-c46a-53e0-bb19aa4ac17a";
    private static final String ARMOR = "d6e8145b-06de-4858-93fd-c089c6e1d453";
    private static final String DAMAGE = "74dd45b4-8227-5e38-b2d6-603efc484d62";
    private ResourceLocation TEXTURE = new ResourceLocation(MoMoFramework.MODID, "textures/gui/demonessence.png");
    public DemonEssence(String name, boolean isBadEffect, int color, int icon) {
        super(name, isBadEffect, color, icon);
        setPotionName(MoMoFramework.MODID+".effect.demonessence");
        //攻速
        registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED,ATTACK_SPEED ,6D,0);
       // 护甲
        registerPotionAttributeModifier(SharedMonsterAttributes.ARMOR, ARMOR, 10, 0);
        //攻击
        registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, DAMAGE, 3.6D, 1);
        //速度
        registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED,ATTACK_SPEED ,0.8D, 1);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, net.minecraft.client.Minecraft mc)
    {
        super.renderInventoryEffect(x, y, effect, mc);
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(x+6, y+8, 0, 0, 18, 18, 18, 18);
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
