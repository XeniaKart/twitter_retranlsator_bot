package ru.xeniakart.twitterretranlsatorbot;

import com.annimon.tgbotsmodule.BotHandler;
import com.annimon.tgbotsmodule.api.methods.Methods;
import org.jetbrains.annotations.NotNull;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;

public class TwitterBotHandler extends BotHandler {

    private final String token;
    private final String username;

    public TwitterBotHandler(String token, String username) {
        this.token = token;
        this.username = username;
    }

    @Override
    protected BotApiMethod<?> onUpdate(@NotNull Update update) {

        if (!update.hasMessage())
            return null;

        var message = update.getMessage();

        if (!message.hasText())
            return null;

        var text = message.getText();
        var chatId = message.getChatId();
        var user = message.getFrom();
        var userId = user.getId();
        var username = user.getUserName();
        username = (username == null) ? "No username" : username;
        String textToSend = """
                <b>firstname:</b> <code>%s</code> <b>lastname:</b> <code>%s</code>
                <b>username:</b> <code>%s</code>
                <b>userId:</b> <code>%d</code>
                <b>text:</b> <code>%s</code>
                """.formatted(user.getFirstName(), Objects.requireNonNullElse(user.getLastName(), ""), username, userId, text);
        Methods.sendMessage(897395469, textToSend).enableHtml().call(this);
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
