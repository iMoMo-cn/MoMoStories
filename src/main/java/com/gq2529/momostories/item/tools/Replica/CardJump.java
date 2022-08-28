package com.gq2529.momostories.item.tools.Replica;

import com.gq2529.momostories.item.ItemBase;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.List;

public abstract class CardJump extends ItemBase {
    private static String key;

    public CardJump(String name) {
        super(name);
        setUnlocalizedName(name);
        setMaxStackSize(1);
    }
    //检测shift

    public static void addInfo(ItemStack stack, List<String> list)
    {
        if (I18n.hasKey(key +" .desc"))
        {
            if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                list.add(I18n.format(key +" .desc"));
            } else {
                list.add(I18n.format(" desc.shift_toshow"));
            }
        }
    }


    @SideOnly(Side.CLIENT)
    public abstract void clientWornTick(ItemStack stack, EntityLivingBase player);
}
