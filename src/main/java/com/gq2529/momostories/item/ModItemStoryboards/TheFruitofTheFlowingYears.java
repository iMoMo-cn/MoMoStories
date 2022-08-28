package com.gq2529.momostories.item.ModItemStoryboards;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.item.tools.CardBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import javax.annotation.Nonnull;
import java.util.List;

public class TheFruitofTheFlowingYears extends CardBase
{
    public TheFruitofTheFlowingYears(String name)
    {
        super(name);
        setMaxStackSize(1);
        setContainerItem(this);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
    }

 //右键效果
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand handIn)
    {
        if (!world.isRemote)
        {
           if (this == ModItems.THE_FRUIT_OF_THE_FLOWING_YEARS)
           {
               int sum = 0;
               for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
               {
                   ItemStack itemStack = player.inventory.getStackInSlot(i);
                   if (itemStack.getItem() == Items.APPLE) {
                       int num = itemStack.getCount();
                       if(sum < 16 && num <= 16 - sum)
                       {
                           itemStack.shrink(num);
                           world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Items.GOLDEN_APPLE, num)));
                           sum += num;
                       }
                       else{
                           itemStack.shrink(16 - sum);
                           world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Items.GOLDEN_APPLE, 16 - sum)));
                           break;
                       }
                   }
                   if (itemStack.getItem() == Items.DRAGON_BREATH)
                   {
                       int num = itemStack.getCount();
                       if(sum < 16 && num <= 16 - sum)
                       {
                           itemStack.shrink(num);
                           world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Items.EXPERIENCE_BOTTLE, num)));
                           sum += num;
                       }
                       else{
                           itemStack.shrink(16 - sum);
                           world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, new ItemStack(Items.EXPERIENCE_BOTTLE, 16 - sum)));
                           break;
                       }
                   }
//                   if (itemStack.getItem() == Items.SKULL)
//                   {
//                       itemStack.shrink(1);
//                       world.spawnEntity(new EntityItem(world,player.posX,player.posY,player.posZ,new ItemStack(Items.SKULL,1,1)));
               }
           }
        }
        return super.onItemRightClick(world, player, handIn);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced)
    {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
        tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.year_2").getFormattedText());
        }
        else
        {
            tooltip.add(TextFormatting.GOLD + new TextComponentTranslation("tooltip.tishi").getFormattedText());
        }
    }
}

