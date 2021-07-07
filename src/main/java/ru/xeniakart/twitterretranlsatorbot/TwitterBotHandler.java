package ru.xeniakart.twitterretranlsatorbot;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.api.methods.Methods;
import com.annimon.tgbotsmodule.commands.context.MessageContext;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.xeniakart.twitterretranlsatorbot.command.CommandRegistry;

import java.util.Objects;

public class TwitterBotHandler extends BotHandler {

    private final String token;
    private final String username;
    private final CommandRegistry commandRegistry;

    public TwitterBotHandler(BotConfig config, CommandRegistry commandRegistry) {
        this.token = config.getToken();
        this.username = config.getUsername();

        this.commandRegistry = commandRegistry;
    }

    @Override
    protected BotApiMethod<?> onUpdate(@NotNull Update update) {

        if (!update.hasMessage())
            return null;

        var message = update.getMessage();

        if (message.getDate() + 120 < System.currentTimeMillis() / 1000) return null;

        if (message.hasSticker()) {
            var sticker = message.getSticker().getFileId();
            Methods.sendDocument(897395469).setFile(sticker).call(this);
            return null;
        }

        if (!message.isCommand())
            return null;

        if (!message.hasText())
            return null;

        var textArgs = message.getText().split("\\s+", 2);
        var command = textArgs[0];

        var commandHandler = commandRegistry.getCommand(command);

        if (commandHandler == null) return null;
        commandHandler.accept(new MessageContext(this, update, textArgs.length < 2 ? "" : textArgs[1]));

        return null;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }
}
