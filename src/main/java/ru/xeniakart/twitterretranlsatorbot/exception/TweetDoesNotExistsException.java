package ru.xeniakart.twitterretranlsatorbot.exception;

public class TweetDoesNotExistsException extends RuntimeException {
    public TweetDoesNotExistsException(String tweetId) {
        super("Tweet " + tweetId + " does not exists.");
    }
}
