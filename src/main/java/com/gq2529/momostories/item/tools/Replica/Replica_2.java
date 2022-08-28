package com.gq2529.momostories.item.tools.Replica;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import com.gq2529.momostories.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
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
import java.util.Random;




@Mod.EventBusSubscriber(modid = Reference.MOD_ID)

//复制品2长枪
public class Replica_2 extends Item implements IHasModel
{
	private final float attackDamage;

	public Replica_2(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		ToolMaterial material = ToolMaterial.DIAMOND;
		setMaxStackSize(1);
		setMaxDamage(material.getMaxUses());
		attackDamage = 3.0F + material.getAttackDamage();
		setCreativeTab(ModCreativeTab.TAB_NAME_4);
		ModItems.ITEMS.add(this);
	}


	//框架特有
	@Override
	public void registerModels()
	{
		MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, @Nonnull EnumHand hand) {
		if (!world.isRemote)
		{

			if (player.getHeldItemMainhand().getItem() == ModItems.REPLICA_2)
			{
				if (player.isSneaking()) {
					ItemStack item = player.getHeldItem(hand);
					item.setCount(item.getCount() - 1);
					player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModItems.REPLICA_3));
					player.getCooldownTracker().setCooldown(player.getHeldItem(hand).getItem(), 5 * 20);
				}
			}
		}
		return super.onItemRightClick(world, player, hand);
	}
	@SubscribeEvent
	public static void REPLICA(LivingHurtEvent event) {
		World world = event.getEntity().world;
		if (!world.isRemote) {
			EntityLivingBase hurt = event.getEntityLiving();
			EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
			if (attacker instanceof EntityPlayer) {
				EntityPlayer Player = (EntityPlayer) attacker;
					if (Player.getHeldItemMainhand().getItem() == ModItems.REPLICA_2) {
						Random O = new Random();
						int num = O.nextInt(3) + 1;
						int num1 = O.nextInt(3) + 1;
						int num2 = O.nextInt(3) + 1;
						hurt.setLocationAndAngles(Player.posX + num, Player.posY + num1, Player.posZ - num2, 0, 0);

					}
				}
			}
		}

	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state)
	{
		Block block = state.getBlock();

		if (block == Blocks.WEB)
		{
			return 15.0F;
		}
		else
		{
			Material material = state.getMaterial();
			return material != Material.PLANTS && material != Material.VINE && material != Material.CORAL && material != Material.LEAVES && material != Material.GOURD ? 1.0F : 1.5F;
		}
	}
	//修改器
	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
	{
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
		{
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.8000000953674316D, 0));
		}

		return multimap;
	}


}