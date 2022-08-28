package com.gq2529.momostories.item.tools.ModTool;
import com.gq2529.momostories.MoMoFramework;
import com.gq2529.momostories.init.ModCreativeTab;
import com.gq2529.momostories.item.ModItems;
import com.gq2529.momostories.util.IHasModel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

//普通的锤子
public class OrdinaryHammer extends ItemPickaxe implements IHasModel {

    public OrdinaryHammer(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTab.TAB_NAME_4);
        ModItems.ITEMS.add(this);
    }
    @Override
    public void registerModels() {
        MoMoFramework.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;
            RayTraceResult result = rayTrace(world, player, false);
            if (result.sideHit == null) return false;
            EnumFacing sideHit = result.sideHit;

            int xDist, yDist, zDist;
            int mineRadius = 1;
            yDist = xDist = zDist = mineRadius;

            int mineDepth = 0;
            switch (sideHit) {
                case UP:
                case DOWN: yDist = mineDepth; break;
                case NORTH:
                case SOUTH: zDist = mineDepth; break;
                case EAST:
                case WEST: xDist = mineDepth; break;
            }

            for (int x = pos.getX() - xDist; x <= pos.getX() + xDist; x++) {
                for (int y = pos.getY() - yDist; y <= pos.getY() + yDist; y++) {
                    for (int z = pos.getZ() - zDist; z <= pos.getZ() + zDist; z++) {
                        BlockPos targetPos = new BlockPos(x, y, z);
                        IBlockState targetBlock = world.getBlockState(targetPos);
                        if (canHarvestBlock(targetBlock, player.getHeldItem(EnumHand.MAIN_HAND))) {
                            if ((stack.getMaxDamage() - stack.getItemDamage()) >= 1 && targetBlock.getBlock() != Blocks.BEDROCK) {
                                if (targetBlock.getBlock().getExpDrop(targetBlock, world, targetPos, 0) > 0) {
                                    if (!world.isRemote && world.getGameRules().getBoolean("doTileDrops")) {
                                        world.spawnEntity(new EntityXPOrb(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, world.getBlockState(pos).getBlock().getExpDrop(targetBlock, world, targetPos, 0)));
                                    }
                                }
                                world.destroyBlock(new BlockPos(x, y, z), true);
                            }
                            stack.damageItem(1, player);
                        }
                    }
                }
            }
            stack.damageItem(1, player);
        }
        return false;
    }
}
