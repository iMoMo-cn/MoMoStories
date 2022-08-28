package com.gq2529.momostories.blocks;

import com.gq2529.momostories.blocks.ModBlock.Id;
import com.gq2529.momostories.init.ModCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();

//	public static final Block BEEFROOT_BEETROOT = new BlockPlant("beefroot_beetroot", Material.PLANTS);
	
	/*
	 * To add a blockBush, put a line here,
	 * -Create a json at assets.eo.blockstates
	 * -Create a json at assets.eo.models.blockBush
	 * -Create a json at assets.eo.models.item
	 * -Add corresponding texture png
	 */

	//public static final Block GRID_BLOCK_1 = new BlockBase("test", Material.CLAY).setCreativeTab(ModCreativeTab.IDL_MISC).setHardness(15f);
	public static final Block ID = new Id("id", Material.IRON).setHardness(20).setResistance(6000000).setCreativeTab(ModCreativeTab.TAB_NAME_4).setLightLevel(0.8F);




}