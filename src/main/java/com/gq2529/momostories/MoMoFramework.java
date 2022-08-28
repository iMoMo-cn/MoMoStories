package com.gq2529.momostories;

import com.gq2529.momostories.gui.ModGuiElementLoader;
import com.gq2529.momostories.init.*;
import com.gq2529.momostories.keys.KeyboardManager;
import com.gq2529.momostories.network.NetworkHandler;
import com.gq2529.momostories.proxy.ProxyBase;
import com.gq2529.momostories.recipe.ModRecipe;
import com.gq2529.momostories.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import static com.gq2529.momostories.util.Reference.MOD_ID;

//Added 'little' steps for making weapons, tools and armor. Enjoy casting and striking as a blacksmith.

@Mod(modid = MoMoFramework.MODID,
        name = MoMoFramework.NAME,
        version = MoMoFramework.VERSION
       // dependencies = "required-after:baubles;"
        )


public class MoMoFramework {
    public static final String MODID = "momostories";
    public static final String NETWORK_CHANNEL = MOD_ID;
    static final String NAME = "MoMoStories";
    static final String VERSION = "1.0.0";

    private static Logger logger;


    private static final boolean SHOW_WARN = true;

    @Mod.Instance
    public static MoMoFramework instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static ProxyBase proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        if (MODID.equals("untitled"))
        {
            logger.error("Please change your mod ID_stone in the main class.");

        }

        if (Reference.CLIENT_PROXY_CLASS.indexOf("somebody.idlframewok.proxy.ClientProxy") > 0)
        {
            logger.warn("Have you changed your package name to author and modname?");
            
        }

        RegistryHandler.preInitRegistries(event);

    }

    @EventHandler
    public static void Init(FMLInitializationEvent event) {

        ModRecipe.Init();

        RegistryHandler.initRegistries(event);
        OreDic.init();


        new ModGuiElementLoader();
        if (!proxy.isServer())
        {
            KeyboardManager.init();
        }
        NetworkHandler.init();
		LogWarning("%s has finished its initializations", MODID);

	}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Moved Spawning registry to last since forge doesn't auto-generate sub
        // "M' biomes until late
        if (ModConfig.SPAWN_CONF.SPAWN) {
            ModSpawn.registerSpawnList();
        }

        TrashTalking();

        RegistryHandler.postInitReg();
    }

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegistries(event);
    }


    private void TrashTalking() {
        MoMoFramework.Log("[Idealland Framework] Made with MoMoFramework.");
    }

    public static void LogWarning(String str, Object... args) {
        if (SHOW_WARN) {
            logger.warn(String.format(str, args));
        }
    }

    public static void LogWarning(String str) {
        if (SHOW_WARN) {
            logger.warn(str);
        }
    }

    public static void Log(String str) {
//        if (ModConfig.GeneralConf.LOG_ON)
//        {
        logger.info(str);
//        }
    }

    public static void Log(String str, Object... args) {
//        if (ModConfig.GeneralConf.LOG_ON)
//        {
        logger.info(String.format(str, args));
//        }
    }

}