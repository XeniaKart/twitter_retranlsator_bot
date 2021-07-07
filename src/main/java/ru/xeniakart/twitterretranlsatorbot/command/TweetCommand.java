package ru.xeniakart.twitterretranlsatorbot.command;

import com.annimon.tgbotsmodule.commands.context.MessageContext;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public class TweetCommand implements BotCommand {

    @Override
    public String command() {
        return "/tweet";
    }

    @Override
    public <TRole extends Enum<TRole>> EnumSet<TRole> authority() {
        ;
        return null;
    }

    @Override
    public void accept(@NotNull MessageContext context) {

    }
}
