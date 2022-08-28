package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
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
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import java.util.List;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//至尊魔导师深湖
public class TheSupremeMagiDeepLake extends CardBase
{
    static String key;
    public TheSupremeMagiDeepLake(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
        setMaxStackSize(1);
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void Deep_lake(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase attack = event.getEntityLiving();
            if (attack instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attack;
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.THE_SUPREME_MAGI_DEEPLAKE)
                    {

                        if (event.getAmount() > 5.0f) {
                            if (0.38 > Math.random()) {
                                attack.addPotionEffect(new PotionEffect(MobEffects.SPEED, 100, 3, false, false));
                                attack.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 2, false, false));
                                attack.maxHurtResistantTime = 100;
                            }
                        }
                    }
                }
            }
        }
    }
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote) {
            EntityPlayer Player = (EntityPlayer) entityIn;
            for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                ItemStack itemStack = Player.inventory.getStackInSlot(i);
                if (itemStack.getItem() == ModItems.THE_ANGERL_PROJECT) {
                    itemStack.shrink(1);
                    Player.sendMessage(new TextComponentTranslation("TheSupremeMagiDeepLakeText1"));
                }

            }
        }
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
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
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.the_supreme").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
