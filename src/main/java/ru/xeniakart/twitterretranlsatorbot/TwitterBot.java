package ru.xeniakart.twitterretranlsatorbot;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.BotModule;
import com.annimon.tgbotsmodule.Runner;
import com.annimon.tgbotsmodule.beans.Config;
import com.annimon.tgbotsmodule.services.YamlConfigLoaderService;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TwitterBot implements BotModule {

    public static void main(String[] args) {
        var profile = (args.length >= 1) ? args[0] : "";
        Runner.run(profile, List.of(new TwitterBot()));
    }

    @Override
    public @NotNull BotHandler botHandler(@NotNull Config config) {
        var configLoader = new YamlConfigLoaderService();
        var configFile = configLoader.configFile("BotConfig", config.getProfile());
        var botConfig = configLoader.loadFile(configFile, BotConfig.class);
        return new TwitterBotHandler(botConfig);
    }
}