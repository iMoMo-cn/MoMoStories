package com.gq2529.momostories.item.tools.ModTool;
import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import com.gq2529.momostories.util.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
//蓝色卡利丹
public class BlueCalidan extends ItemHoe implements IHasModel {
    private static final Item.ToolMaterial BOUNDLESS_MATERIAL = EnumHelper.addToolMaterial("boundless_material", 5, 3000, 8, 4, 9);

    public BlueCalidan(String name) {
        super(BOUNDLESS_MATERIAL);
        setUnlocalizedName(name);
        setRegistryName(name);
        maxStackSize = 1;
        ModItems.ITEMS.add(this);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
    }

    //框架特有
    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @SubscribeEvent
    public static void luna_hunting(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                if (Player.getHeldItemMainhand().getItem() == ModItems.BLUE_CALIDAN) {
                    event.setAmount(event.getAmount() + 6);
                }
            }
        }
    }
}

