package com.gq2529.momostories.blocks.blockDecoration;

import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.blocks.ModBlocks;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import com.gq2529.momostories.util.IItemProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Slab extends BlockSlab implements IHasModel, IItemProvider {
    private boolean isDouble;
    public Block dropBlock;
    private BlockSlab doubleSlab;

    public static final PropertyEnum<Variant> VARIANT = PropertyEnum.<Slab.Variant>create("variant", Slab.Variant.class);

    public Slab(String name, MapColor mapColor)
    {
        this(name, true, mapColor, null);
    }

    public Slab(String name, MapColor mapColor, BlockSlab doubleSlab)
    {
        this(name, false, mapColor, doubleSlab);
    }

    public Slab(String name, boolean isDouble, MapColor mapColor, BlockSlab doubleSlab)
    {
        super(Material.ROCK, mapColor);
        this.setResistance(10.0F);
        this.setHardness(2.0F);
        this.setSoundType(SoundType.STONE);

        this.doubleSlab = doubleSlab;
        this.isDouble = isDouble;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);

        ModBlocks.BLOCKS.add(this);

        ItemBlock itemBlock = this.createItemBlock();

        IBlockState iblockstate = this.blockState.getBaseState();
        if (!this.isDouble())
        {
            this.dropBlock = this;
            iblockstate = iblockstate.withProperty(HALF, EnumBlockHalf.BOTTOM);
            ModItems.ITEMS.add(itemBlock.setRegistryName(name));
        }

        this.setDefaultState(iblockstate.withProperty(VARIANT, Slab.Variant.DEFAULT));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        useNeighborBrightness = true;
    }

    @Override
    public ItemBlock createItemBlock() { return new ItemSlab(this, this, doubleSlab);}

    @Override
    public void registerModels() {
        if(!this.isDouble()) MoMoFramework.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    protected BlockStateContainer createBlockState() {
//      return new BlockStateContainer(this, HALF);
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {VARIANT}) : new BlockStateContainer(this, new IProperty[] {HALF, VARIANT});
    }

    public String getUnlocalizedName(int meta)
    {
        return super.getUnlocalizedName();
    }

    public IProperty<?> getVariantProperty()
    {
        return VARIANT;
    }

    @Override
    public boolean isDouble() { return isDouble; }

    @Override
    public Comparable<?> getTypeForItem(ItemStack stack)
    {
        return Slab.Variant.DEFAULT;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
//        return isDouble() ? 0 : state.getValue(HALF).ordinal() + 1;
        int i = 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
        {
            i |= 8;
        }

        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
//      return !isDouble() ? getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]) : getDefaultState();

        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, Slab.Variant.DEFAULT);
        if (!this.isDouble())
        {
            iblockstate = iblockstate.withProperty(HALF, (meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
        }
        return iblockstate;
    }



    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(dropBlock, 1, dropBlock.damageDropped(state));
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        if(this.isDouble()){
            drops.add(new ItemStack(dropBlock, 2));
        }
        else {
            drops.add(new ItemStack(dropBlock, 1));
        }
    }

    public Slab setDropped(Block dropBlockIn){
        this.dropBlock = dropBlockIn;
        return this;
    }

    public static enum Variant implements IStringSerializable
    {
        DEFAULT;

        public String getName()
        {
            return "default";
        }
    }
}
