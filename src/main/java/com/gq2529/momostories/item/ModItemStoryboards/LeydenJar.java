package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.util.Reference;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import java.util.List;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//莱顿瓶
public class LeydenJar extends CardBase
{
    static String key;
    public LeydenJar(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
        setMaxStackSize(1);
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
                    if (itemStack.getItem() == ModItems.LEYDEN_JAR) {
                        if (world.isRaining()) {
                            world.addWeatherEffect(new EntityLightningBolt(world, hurt.posX, hurt.posY, hurt.posZ, false));
                        }
                        if (hurt.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD)
                        {
                            event.setAmount(event.getAmount() * 1.5F);
                        }
                    }
                }
            }
        }
    }
    //工具文本提示
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
    {
        //shift文本显示
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
        //第一行，以此类推
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.LeydenJar_3").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
        super.addInformation(stack, world, tooltip, flag);
    }
}
