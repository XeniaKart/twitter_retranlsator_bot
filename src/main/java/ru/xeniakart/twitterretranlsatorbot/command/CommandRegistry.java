package ru.xeniakart.twitterretranlsatorbot.command;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.commands.authority.Authority;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CommandRegistry {

    private final Map<String, BotCommand> commands;

    public CommandRegistry(Set<BotCommand> commands) {
        this.commands = new HashMap<>();

        for (var cmd : commands) {
            this.commands.put(cmd.command(), cmd);
        }
    }

    public BotCommand getCommand(String command) {
        return commands.get(command);
    }

}
