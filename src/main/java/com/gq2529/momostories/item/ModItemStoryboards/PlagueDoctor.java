package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class PlagueDoctor extends CardBase {
    public PlagueDoctor(String name) {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_1);
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
          /*  EntityPlayer Player = (EntityPlayer) entityIn;
            if (this == ModItems.PLAGUE_DOCTOR) {
                if (worldIn.getWorldTime() % 20 == 1) {
                    EntityUtil.TryRemoveDebuff(Player);
                    Player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS,  20));
                }
            }*/
            EntityLivingBase Player = (EntityLivingBase) entityIn;
            Collection<PotionEffect> activePotionEffects = Player.getActivePotionEffects();
            for (int i = 0; i < activePotionEffects.size(); i++) {
                PotionEffect buff = (PotionEffect) activePotionEffects.toArray()[i];
                    if (buff.getPotion().isBadEffect()) {
                        if (worldIn.getWorldTime() % 20 == 2) {
                            if (0.25 > Math.random()) {
                            Player.removePotionEffect(buff.getPotion());
                        }
                        if (0.25 > Math.random()) {
                            Player.removePotionEffect(buff.getPotion());
                            Player.setHealth(5);
                        }
                        if (0.25 > Math.random()) {
                            Player.removePotionEffect(buff.getPotion());
                            Player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 * 5, 1));
                        }
                        if (0.25 > Math.random()) {
                            Player.removePotionEffect(buff.getPotion());
                                Player.dropItem(ModItems.FAKE_DIAMOND, 64);

                        }
                    }
                }
                super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
            }
        }
    }

            //工具文本
            @Override
            @SideOnly(Side.CLIENT)
            public void addInformation (ItemStack stack, World player, List < String > tooltip, ITooltipFlag
            advanced)
            {
                //shift文本显示
                if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    //第一行，以此类推
                    tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.plague_doctor_4").getFormattedText());
                } else {
                    tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
                }
            }
        }


