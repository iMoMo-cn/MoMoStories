    package com.gq2529.momostories.item.tools;
    import org.lwjgl.input.Keyboard;
    import com.gq2529.momostories.item.ItemBase;
    import net.minecraft.client.resources.I18n;
    import net.minecraft.item.ItemStack;

    import java.util.List;
    public abstract class CardBase extends ItemBase
    {
    private static String key;

    public CardBase(String name)
            {
            super(name );
            setUnlocalizedName(name);
            setMaxStackSize(1);

            }
    //shift

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



    }
