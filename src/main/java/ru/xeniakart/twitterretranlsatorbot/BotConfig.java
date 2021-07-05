package ru.xeniakart.twitterretranlsatorbot;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BotConfig {
    @JsonProperty
    private String token;
    @JsonProperty
    private String username;
    @JsonProperty
    private String database;

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
}
