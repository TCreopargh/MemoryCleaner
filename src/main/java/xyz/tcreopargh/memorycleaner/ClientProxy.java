package xyz.tcreopargh.memorycleaner;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        if (Configuration.cleanOnInit) {
            MemoryManager.cleanMemory();
        }
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
        if (Configuration.cleanOnInit) {
            MemoryManager.cleanMemory();
        }
    }

    public void postInit(FMLPostInitializationEvent event) {
        MemoryCleaner.logger.info("Registering Command: " + CleanMemoryCommand.NAME);
        ClientCommandHandler.instance.registerCommand(new CleanMemoryCommand());
        super.postInit(event);
        if (Configuration.cleanOnInit) {
            MemoryManager.cleanMemory();
        }
    }
}
