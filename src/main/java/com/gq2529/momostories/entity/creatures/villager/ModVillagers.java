package com.gq2529.momostories.entity.creatures.villager;

import com.gq2529.momostories.MoMoFramework;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.ArrayList;
import java.util.List;


public class ModVillagers {

    public static final List<VillagerRegistry.VillagerProfession> VILLAGERS = new ArrayList<VillagerRegistry.VillagerProfession>();
    //example

//    public static final VillagerRegistry.VillagerProfession VILLAGER_NAME = new ProfessionBase("name");
//    public static final VillagerRegistry.VillagerCareer VILLAGER_NAME_CAREER = new CareerBase(VILLAGER_NAME,"name");






    public static class ProfessionBase extends VillagerRegistry.VillagerProfession{

        public ProfessionBase(String name)
        {
            super(MoMoFramework.MODID + name,
                    MoMoFramework.MODID + ":textures/entity/villager/" + name + ".png",
                    MoMoFramework.MODID + ":textures/entity/zombie_villager/zombie_" + name + ".png");

            VILLAGERS.add(this);
        }
    }

    public static class CareerBase extends VillagerRegistry.VillagerCareer{

        public CareerBase(VillagerRegistry.VillagerProfession parent, String name) {
            super(parent, MoMoFramework.MODID + name);
        }
    }
}
