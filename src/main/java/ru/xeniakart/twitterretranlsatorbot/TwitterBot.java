package ru.xeniakart.twitterretranlsatorbot;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.BotModule;
import com.annimon.tgbotsmodule.Runner;
import com.annimon.tgbotsmodule.beans.Config;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TwitterBot implements BotModule {

    @Override
    public @NotNull BotHandler botHandler(@NotNull Config config) {
        String token = System.getenv("token");
        String username = System.getenv("username");
        return new TwitterBotHandler(token, username);
    }

    public static void main(String[] args) {
        Runner.run(List.of(new TwitterBot()));
    }
}
