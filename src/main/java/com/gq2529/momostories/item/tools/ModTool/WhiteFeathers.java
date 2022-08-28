package com.gq2529.momostories.item.tools.ModTool;
import com.google.common.collect.Multimap;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ItemBase;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.UUID;
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class WhiteFeathers  extends ItemBase {
    private double attackDamage;
    private static final ToolMaterial material = EnumHelper.addToolMaterial("boundless_material",5,2000,15,1,20);
    public WhiteFeathers(String name) {
        super(name);
        setUnlocalizedName(name);
        setMaxDamage(2000);
        setMaxStackSize(1);
        attackDamage = 12f;
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
    }
    public boolean isRepairable()
    {
        return true;
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return false;
    }

    public boolean isBookEnchantable(ItemStack stack, ItemStack book)
    {
        return true;
    }

    public int getItemEnchantability() {
        return material.getEnchantability();
    }

    public boolean isEnchantable(ItemStack stack) { return true; }

    public boolean canDisableShield(ItemStack stack, ItemStack shield, EntityLivingBase entity, EntityLivingBase attacker)
    {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment.type == EnumEnchantmentType.WEAPON) {
            return true;
        }

        return super.canApplyAtEnchantingTable(stack, enchantment);
    }
    @SubscribeEvent
    public static void Proof_of_Glory(LivingHurtEvent event) {
        World world = event.getEntity().world;
        if (!world.isRemote) {
            EntityLivingBase hurt = event.getEntityLiving();
            EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
            if (attacker instanceof EntityPlayer) {
                EntityPlayer Player = (EntityPlayer) attacker;
                if (Player.getHeldItemMainhand().getItem() == ModItems.WHITE_FESTHERS) {
                    hurt.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 3 * 20, 2));
                }
            }
        }
    }
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        UUID uuid = new UUID((getUnlocalizedName() + equipmentSlot.toString()).hashCode(), 0);
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(uuid, "Weapon modifier",0.2D,0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(uuid, "Weapon modifier", 1.82D, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(uuid, "Weapon modifier", this.attackDamage, 0));
        }
        if (equipmentSlot == EntityEquipmentSlot.OFFHAND) {
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(uuid, "Weapon modifier",0.2D,0));
            multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(uuid, "Weapon modifier", 6D, 0));
        }
        return multimap;
    }
    /*MAINHAND*/
}
