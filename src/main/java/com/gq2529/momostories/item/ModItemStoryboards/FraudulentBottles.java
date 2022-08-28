package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;
public class FraudulentBottles extends CardBase
{
    static String key;
    public FraudulentBottles(String name)
    {
        super(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_1);
        setMaxStackSize(1);
    }
    //右键效果
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand)
    {
        if ( !world.isRemote) {
            if (this == ModItems.FRAUDULENT_BOTTLES) {
                for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
                {
                    ItemStack itemStack = player.inventory.getStackInSlot(i);
                    if (itemStack.getItem() == Items.DIAMOND)
                    {
                        Random r = new Random();
                        int num = r.nextInt(2);
                        if(num > 0) {
                            itemStack.shrink(1);
                            if(!player.inventory.addItemStackToInventory(new ItemStack(Blocks.DEADBUSH, 1)))
                            {
                                player.entityDropItem(new ItemStack(Blocks.DEADBUSH, 1), 0);
                            }
                            player.sendMessage(new TextComponentTranslation("FraudulentBottlesText1"));
                        }
                        else
                            {
                            itemStack.shrink(1);
                            if(!player.inventory.addItemStackToInventory(new ItemStack(ModItems.FAKE_DIAMOND, 2)))
                            {
                                player.entityDropItem(new ItemStack(ModItems.FAKE_DIAMOND, 2), 0);
                            }
                                player.sendMessage(new TextComponentTranslation("FraudulentBottlesText2"));
                        }
                    }
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
    }
    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.fraudulent_bottles_3").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
        super.addInformation(stack, world, tooltip, flag);
    }
}



