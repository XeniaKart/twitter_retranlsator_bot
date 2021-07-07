package ru.xeniakart.twitterretranlsatorbot;

public class TweetIdExtractor {
    public static String extract(String url) {
        return url.replaceAll(".*/status/(\\d+).*", "%1");
    }
}
