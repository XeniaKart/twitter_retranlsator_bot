package ru.xeniakart.twitterretranlsatorbot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BotConfig {
    @JsonProperty
    private String token;
    @JsonProperty
    private String username;
    @JsonProperty
    private String database;
    @JsonProperty
    private String apiKey;
    @JsonProperty
    private String apiSecretKey;
    @JsonProperty
    private String accessToken;
    @JsonProperty
    private String accessTokenSecret;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecretKey() {
        return apiSecretKey;
    }

    public void setApiSecretKey(String apiSecretKey) {
        this.apiSecretKey = apiSecretKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
}
