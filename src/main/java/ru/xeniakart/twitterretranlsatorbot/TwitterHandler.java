package ru.xeniakart.twitterretranlsatorbot;

import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.dto.tweet.Tweet;
import io.github.redouane59.twitter.signature.TwitterCredentials;
import ru.xeniakart.twitterretranlsatorbot.exception.TweetDoesNotExistsException;

import java.util.NoSuchElementException;

public class TwitterHandler {
    private final TwitterClient twitterClient;

    public TwitterHandler(BotConfig config) {
        this.twitterClient = new TwitterClient(TwitterCredentials.builder()
                .accessToken(config.getAccessToken())
                .accessTokenSecret(config.getAccessTokenSecret())
                .apiKey(config.getApiKey())
                .apiSecretKey(config.getApiSecretKey())
                .build());
    }

    public Tweet getTweet(String tweetId) {
        try {
            return twitterClient.getTweet(tweetId);
        } catch (NoSuchElementException e) {
            throw new TweetDoesNotExistsException(tweetId);
        }
    }

}
