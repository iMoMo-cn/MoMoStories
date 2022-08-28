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
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import java.util.List;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//斯利姆堡
public class FortSlim extends CardBase
{
    public FortSlim(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
    }

    @SubscribeEvent
    public static void luna_hunting(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.FORT_SLIM) {
                        hurt.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 60, 255, false, false));
                    }
                }
            }
        }
    }
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand)
    {
        //判断物品和服务端
        if (this == ModItems.FORT_SLIM && !world.isRemote)
        {
            int a = (int) player.getHealth();
            player.setHealth(a - 6);
            player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 255,false,false));//缓慢
            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 200, 14,false,false));//吸收
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 4,false,false));//抗性
            player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(),60 * 20 );
        }
        return super.onItemRightClick(world, player, hand);
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
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.fort_slim_3").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
