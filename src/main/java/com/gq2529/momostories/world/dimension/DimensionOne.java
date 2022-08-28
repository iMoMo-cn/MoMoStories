package com.gq2529.momostories.world.dimension;

import com.gq2529.momostories.world.dimension.hexcube.ChunkGeneratorHexCube16;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionOne extends WorldProvider {

    public DimensionOne() {
        //this.biomeProvider = new BiomeProviderSingle(ModBiomeInit.BIOME_ONE);
        hasSkyLight = false;
    }

    @Override
    public DimensionType getDimensionType() {
        return DimensionType.NETHER;
        //return ModDimensionInit.DIM_ONE;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorHexCube16( world, true, world.getSeed());
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }


}
