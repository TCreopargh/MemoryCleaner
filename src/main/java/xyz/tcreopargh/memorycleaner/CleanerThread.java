package xyz.tcreopargh.memorycleaner;

import net.minecraft.command.ICommandSender;
import net.minecraftforge.server.command.TextComponentHelper;

public class CleanerThread implements Runnable {

    private ICommandSender sender = null;

    public CleanerThread(ICommandSender sender) {
        this.sender = sender;
    }

    public CleanerThread() {

    }

    @Override
    public void run() {
        MemoryCleaner.logger.info("Memory cleaner thread started!");
        if (sender != null && Configuration.showMessage) {
            sender.sendMessage(TextComponentHelper.createComponentTranslation(sender, "memorycleaner.gc.start"));
        }
        System.gc();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ignored) {
        }
        System.gc();
        if (sender != null && Configuration.showMessage) {
            sender.sendMessage(TextComponentHelper.createComponentTranslation(sender, "memorycleaner.gc.end"));
        }
        MemoryCleaner.logger.info("Memory cleaner thread finished!");
    }
}
