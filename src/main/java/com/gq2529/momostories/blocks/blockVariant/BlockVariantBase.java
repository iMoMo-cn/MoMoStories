package com.gq2529.momostories.blocks.blockVariant;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.blocks.BlockBase;
import com.gq2529.momostories.item.ItemBlockVariant;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IMetaName;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockVariantBase extends BlockBase implements IMetaName
{
    public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

    public BlockVariantBase(String name, Material material) {
        super(name, material);

        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.STONE));
    }

    public void addToItems()
    {
        ModItems.ITEMS.add(new ItemBlockVariant(this).setRegistryName(this.getRegistryName()));
    }

    /**
     * Gets the metadata of the item this BlockPhasingOre can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return state.getValue(VARIANT).getMeta();
    }

    /**
     * Convert the given metadata into a BlockState for this BlockPhasingOre
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, EnumType.values()[meta]);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(VARIANT).getMeta();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (EnumType variant : EnumType.values())
        {
            items.add(new ItemStack(this, 1, variant.getMeta()));
        }
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels()
    {
        for (int i = 0; i < EnumType.values().length; i++) {
            MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), i, getUnlocalizedName() + "_" + EnumType.values()[i].getName());
        }
    }

    public static enum EnumType implements IStringSerializable
    {
        STONE(0, "1", MapColor.STONE);


        private static final EnumType[] META_LOOKUP = new EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final MapColor mapColor;

        private EnumType(int metaIn, String nameIn, MapColor colorIn)
        {
            this(metaIn, nameIn, nameIn, colorIn);
        }

        private EnumType(int metaIn, String nameIn, String unlocalizedNameIn, MapColor colorIn)
        {
            this.meta = metaIn;
            this.name = nameIn;
            this.unlocalizedName = unlocalizedNameIn;
            this.mapColor = colorIn;
        }

        @Override
        public String getName(){
            return this.name;
        }

        public int getMeta(){
            return this.meta;
        }

        public MapColor getMapColor(){
            return this.mapColor;
        }
    }
}

