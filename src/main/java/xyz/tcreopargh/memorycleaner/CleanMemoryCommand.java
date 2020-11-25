package xyz.tcreopargh.memorycleaner;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.IClientCommand;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class CleanMemoryCommand extends CommandBase implements IClientCommand {

    public static final String NAME = "cleanmemory";

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        MemoryManager.cleanMemory(sender);
        Events.lastCleanTime = System.currentTimeMillis();
    }

    @Override
    @MethodsReturnNonnullByDefault
    public String getName() {
        return NAME;
    }

    @Override
    @MethodsReturnNonnullByDefault
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        for (String string : Configuration.commandAliases.split("\\s+")) {
            if(!string.isEmpty()) {
                aliases.add(string);
            }
        }
        return aliases;
    }

    @Override
    @MethodsReturnNonnullByDefault
    public String getUsage(ICommandSender sender) {
        return "/cleanmemory";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean allowUsageWithoutPrefix(ICommandSender sender, String message) {
        return false;
    }
}
