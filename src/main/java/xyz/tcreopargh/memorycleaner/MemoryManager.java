package xyz.tcreopargh.memorycleaner;

import net.minecraft.command.ICommandSender;

public class MemoryManager {

    public static void cleanMemory(ICommandSender sender) {
        Runnable runnable = new CleanerThread(sender);
        Thread gcThread = new Thread(runnable, "MemoryCleaner GC Thread");
        gcThread.setDaemon(true);
        gcThread.start();
    }
}
