package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class AiLingWishes extends CardBase
{
    public AiLingWishes(String name)
    {
        super(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);

    }
    @SubscribeEvent
    public static void erin(LivingDeathEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            if (event.getEntityLiving() instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) event.getEntityLiving();
                for (int i = 0; i < Player.inventory.getSizeInventory(); ++i) {
                    ItemStack itemStack = Player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == ModItems.AI_LING_WISHES) {
                        Player.setHealth(1);
                        event.setCanceled(true);
                        Player.hurtResistantTime = 30;
                        Player.getCooldownTracker().setCooldown(ModItems.AI_LING_WISHES, 60 * 20);
                    }
                }
            }
        }
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
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.ai_lings_wishes_4").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
