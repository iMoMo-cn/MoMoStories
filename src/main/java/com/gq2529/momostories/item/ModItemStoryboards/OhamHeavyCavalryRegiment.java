package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import com.gq2529.momostories.potion.effect.ModPotions;
import com.sun.scenario.effect.Effect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

import static net.minecraft.init.MobEffects.BLINDNESS;


public class OhamHeavyCavalryRegiment extends CardBase
{
    public OhamHeavyCavalryRegiment(String name)
    {
        super(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(ModCreativeTab.TAB_NAME_2);
    }
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if (!worldIn.isRemote)
        {
            EntityPlayer Player = (EntityPlayer) entityIn;
            if (this == ModItems.OHAM_HEAVY_CAVALRY_REGIMENT) {
                Player.addPotionEffect(new PotionEffect(ModPotions.HEAVY_ARMOR, 20));
            }
              super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
         }
    }

   /*
   @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand)
    {

        if (this == ModItems.OHAM_HEAVY_CAVALRY_REGIMENT && !world.isRemote)
        {
          player.setGameType(GameType.CREATIVE);
            if(world.rand.nextInt(10) == 0) {
                player.setGameType(GameType.SURVIVAL);

            }
        }
        return super.onItemRightClick(world, player, hand);
    }*/

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.oham_heavy_cavalry_regiment_2").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}
