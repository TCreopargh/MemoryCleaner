package xyz.tcreopargh.memorycleaner;

import net.minecraftforge.common.config.Config;

@Config(modid = MemoryCleaner.MOD_ID)
public class Configuration {
    @Config.LangKey("memorycleaner.config.show_message")
    @Config.Comment("Whether to show a message when the cleaning starts or ends. [default: true]")
    public static boolean showMessage = true;

    @Config.LangKey("memorycleaner.config.min_interval")
    @Config.RangeInt(min = 30)
    @Config.Comment("The minimum time, in seconds, between memory cleanings. Note that the actual cleaning interval is usually longer than this due to player activity. [default: 300]")
    public static int minInterval = 300;

    @Config.LangKey("memorycleaner.config.max_interval")
    @Config.RangeInt(min = 60)
    @Config.Comment("The maximum time, in seconds, between memory cleanings. If this amount of time is passed since the last cleaning, a forced memory cleaning will start regardless of player activity. Set to a very large number to effectively disable forced cleaning triggered by this. DO NOT SET THIS LESSER THAN minInterval! [default: 1200]")
    public static int maxInterval = 1200;

    @Config.LangKey("memorycleaner.config.force_clean_percentage")
    @Config.RangeInt(min = 0, max = 100)
    @Config.Comment("If your RAM usage goes above this percentage, memory cleaning will start regardless of player activity, but it still respects minInterval. Set to 100 to disable the feature or 0 to ignore player activity at any time. [default: 80]")
    public static int forceCleanPercentage = 80;

    @Config.LangKey("memorycleaner.config.min_idle_time")
    @Config.RangeInt(min = 5)
    @Config.Comment("If the player keeps inactive for this amount of time (in seconds), a memory cleaning will start if minInterval has already been met. [default: 30]")
    public static int minIdleTime = 30;

    @Config.LangKey("memorycleaner.config.clean_on_join")
    @Config.Comment("Whether to clean memory immediately when joining a world. This disrespects minInterval. If this is set to false, a minimum time of minInterval has to pass before the memory can be cleaned for the first time. [default: true]")
    public static boolean cleanOnJoin = true;

    @Config.RequiresMcRestart
    @Config.LangKey("memorycleaner.config.command_aliases")
    @Config.Comment("Aliases for the memory cleaning command, if you want to add multiple, spilt them with spaces. [default: ]")
    public static String commandAliases = "";

}
