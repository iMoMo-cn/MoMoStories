package com.gq2529.momostories.recipe;

import com.google.common.collect.Sets;
import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.util.Reference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import java.util.Set;

import static com.gq2529.momostories.MoMoFramework.LogWarning;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModRecipe {

	public static Set<ResourceLocation> recipes = Sets.newHashSet();
	
	public static void Init() {
		//Only smelting recipes
		//GameRegistry.addSmelting(ModItems.XXXX, new ItemStack(ModItems.XXXX), 0.3f);
	}
	
	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> evt) {
		IForgeRegistry<IRecipe> r = evt.getRegistry();
		IForgeRegistryModifiable<IRecipe> registry = (IForgeRegistryModifiable<IRecipe>) r;

		//remove recipe
		removeRecipes(registry);

		//Example
		//r.register(new BasicGua8().setRegistryName(new ResourceLocation(Reference.MOD_ID, "basic_gua8")));

	}
	private static void removeRecipes(IForgeRegistryModifiable<IRecipe> registry){

		//removeRecipe(new ItemStack(Blocks.TRAPDOOR, 2));
		//removeAllRecipe

		recipes.forEach(rl -> {
			if(!rl.getResourceDomain().equals(MoMoFramework.MODID)) {
				LogWarning("Removing: " + rl);
				registry.remove(rl);
			}
		});
	}

	private static void removeRecipe(ItemStack resultItem){
		CraftingManager.REGISTRY.forEach((recipe) -> {
			if(ItemStack.areItemsEqual(recipe.getRecipeOutput(), resultItem)) {
				recipes.add(recipe.getRegistryName());
			}
		});
	}

	private static void removeAllRecipe(){
		CraftingManager.REGISTRY.forEach((recipe) -> recipes.add(recipe.getRegistryName()));
	}
}
