package xyz.tcreopargh.memorycleaner;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = MemoryCleaner.MOD_ID,
        name = MemoryCleaner.MOD_NAME,
        version = MemoryCleaner.VERSION
)
public class MemoryCleaner {

    public static final String MOD_ID = "memorycleaner";
    public static final String MOD_NAME = "Memory Cleaner";
    public static final String VERSION = "1.2";

    @Mod.Instance(MOD_ID)
    public static MemoryCleaner INSTANCE;

    public static Logger logger;

    public static final String CLIENT_PROXY = "xyz.tcreopargh.memorycleaner.ClientProxy";
    public static final String COMMON_PROXY = "xyz.tcreopargh.memorycleaner.CommonProxy";
    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
