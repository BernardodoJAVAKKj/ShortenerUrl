package com.example.Url;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ShortUrl {


    private Map<String, String> shortUrl = new HashMap<String, String>();


    private String url;
    private String shortCode;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    // Getters e Setters


    public Map<String, String> getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(Map<String, String> shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortCode() {
        return shortCode;
    }
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
