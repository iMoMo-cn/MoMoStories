package com.gq2529.momostories;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

public class ConfingLoader
{
    private static Configuration config;

    private static Logger logger;

    public static int diamondBurnTime;

    public ConfingLoader(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        load();

    }

    public static void load()
    {
        logger.info("Started loading config. ");
        String comment;

        comment = "How many seconds can a diamond burn in a furnace. ";
        diamondBurnTime = config.get(Configuration.CATEGORY_GENERAL, "diamondBurnTime", 640, comment).getInt();
        Loader.isModLoaded("IC2");
        config.save();
        logger.info("Finished loading config. ");
    }

    public static Logger logger()
    {
        return logger;
    }
}
