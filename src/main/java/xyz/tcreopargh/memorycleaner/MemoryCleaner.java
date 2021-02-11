package xyz.tcreopargh.memorycleaner;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@Mod(
        modid = MemoryCleaner.MOD_ID,
        name = MemoryCleaner.MOD_NAME,
        version = MemoryCleaner.VERSION
)
public class MemoryCleaner {

    public static final String MOD_ID = "memorycleaner";
    public static final String MOD_NAME = "Memory Cleaner";
    public static final String VERSION = "1.4";
    public static final String CLIENT_PROXY = "xyz.tcreopargh.memorycleaner.ClientProxy";
    public static final String COMMON_PROXY = "xyz.tcreopargh.memorycleaner.CommonProxy";
    @Mod.Instance(MOD_ID)
    public static MemoryCleaner INSTANCE;
    public static Logger logger;
    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy;

    @NetworkCheckHandler
    public boolean checkModList(final Map<String, String> versions, final Side side) {
        return true;
    }

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
