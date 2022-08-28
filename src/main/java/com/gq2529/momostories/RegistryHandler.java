package com.gq2529.momostories;

import com.gq2529.momostories.enchantments.ModEnchantmentInit;
import com.gq2529.momostories.entity.creatures.ModEntityInit;
import com.gq2529.momostories.entity.creatures.villager.ModVillagers;
import com.gq2529.momostories.entity.creatures.villager.VillagerMerchants;
import com.gq2529.momostories.entity.renders.RenderHandler;
import com.gq2529.momostories.blocks.ModBlocks;
import com.gq2529.momostories.init.ModBiomeInit;
import com.gq2529.momostories.init.ModDimensionInit;
import com.gq2529.momostories.item.ModItems;

import com.gq2529.momostories.potion.effect.ModPotions;
import com.gq2529.momostories.potion.item.ModPotionTypes;
import com.gq2529.momostories.util.IHasModel;
import com.gq2529.momostories.util.sound.ModSoundHandler;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onEnchantmentRegister(RegistryEvent.Register<Enchantment> event)
	{
		ModEnchantmentInit.BeforeRegister();
		event.getRegistry().registerAll(ModEnchantmentInit.ENCHANTMENT_LIST.toArray(new Enchantment[0]));
	}

	@SubscribeEvent
	public static void onPotionRegistry(RegistryEvent.Register<Potion> event)
	{
		event.getRegistry().registerAll(ModPotions.POTIONS.toArray(new Potion[0]));
	}

	@SubscribeEvent
	public static void onPotionTypeRegistry(RegistryEvent.Register<PotionType> event)
	{
		event.getRegistry().registerAll(ModPotionTypes.POTION_TYPES.toArray(new PotionType[0]));
	}

	@SubscribeEvent
	public static void onRegistry(RegistryEvent.Register<VillagerRegistry.VillagerProfession>event)
	{
		VillagerMerchants.addMerchants();
		event.getRegistry().registerAll(ModVillagers.VILLAGERS.toArray(new VillagerRegistry.VillagerProfession[0]));
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if (item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if (block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}

		RenderHandler.registerEntityRenders();
	}

	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		//GameRegistry.registerWorldGenerator(new ModWorldGenOld(), 100);
		//GameRegistry.registerWorldGenerator(new ModWorldGenNew(), 120);

		ModBiomeInit.registerBiomes();
		ModDimensionInit.registerDimensions();
		ModPotionTypes.registerPotionType();
		ModEntityInit.registerEntities();
	}

	public static void postInitReg()
	{
		//WorldType TYPE_ONE = new WorldTypeOne();
	}

	public static void initRegistries(FMLInitializationEvent event)
	{
		ModSoundHandler.soundRegister();
	}

	public static void serverRegistries(FMLServerStartingEvent event)
    {
        //event.registerServerCommand(new CommandDimTeleport());
    }

}
