package xyz.tcreopargh.memorycleaner;

import net.minecraft.command.ICommandSender;
import net.minecraftforge.server.command.TextComponentHelper;

public class CleanerThread implements Runnable {

    private final ICommandSender sender;

    CleanerThread(ICommandSender sender) {
        this.sender = sender;
    }

    @Override
    public void run() {
        if(Configuration.showMessage) {
            sender.sendMessage(TextComponentHelper.createComponentTranslation(sender, "memorycleaner.gc.start"));
        }
        System.gc();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ignored) {
        }
        System.gc();
        if(Configuration.showMessage) {
            sender.sendMessage(TextComponentHelper.createComponentTranslation(sender, "memorycleaner.gc.end"));
        }
    }
}
