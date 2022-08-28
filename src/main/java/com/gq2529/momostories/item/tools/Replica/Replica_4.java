package com.gq2529.momostories.item.tools.Replica;

import com.google.common.collect.Multimap;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ItemBase;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nonnull;
import java.util.UUID;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class Replica_4  extends ItemBase {
    private double attackDamage;

    public Replica_4(String name) {
        super(name);
        setUnlocalizedName(name);
        attackDamage = 4f;
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
    }

    @SubscribeEvent
    public static void Replica(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                if (Player.getHeldItemMainhand().getItem() == ModItems.REPLICA_4) {
                    if (hurt.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD)
                    {
                      event.setAmount(event.getAmount() * 10F);
                   }
                }
            }
        }
    }
    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
        if (!world.isRemote)
        {

            if (player.getHeldItemMainhand().getItem() == ModItems.REPLICA_4)
            {
                if (player.isSneaking()) {
                    ItemStack item = player.getHeldItem(hand);
                    item.setCount(item.getCount() - 1);
                    player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.THE_BOOK_OF_FORGERY));
                    player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 5 * 20);
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
    }
@Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID((getUnlocalizedName() + equipmentSlot.toString()).hashCode(), 0);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(uuid, "Weapon modifier", this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(uuid, "Weapon modifier", -2.2000000953674316D, 0));
            //  multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(uuid, "Weapon modifier",2,0));
        }
        return multimap;
    }
}
