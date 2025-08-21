package com.example.Url;

import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShortService {

    private Map<String, ShortUrl> shortMap = new HashMap<>();


    public String encurtar(String Url, LocalDateTime ExpiredAT) {

        if (!validationUrl(Url)) {
            return null;
        }

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setUrl(Url);
        shortUrl.setShortCode(codeGenerator(6));
        shortUrl.setCreatedAt(LocalDateTime.now());
        shortUrl.setExpiresAt(ExpiredAT != null ? ExpiredAT : shortUrl.getCreatedAt().plusMinutes(1));

        shortMap.put(shortUrl.getShortCode(), shortUrl);
        return shortUrl.getShortCode();
    }


    public String rescue(String shortCode) {
        ShortUrl shortUrl = shortMap.get(shortCode);

        if (shortUrl != null && LocalDateTime.now().isBefore(shortUrl.getExpiresAt())) {
            return shortUrl.getUrl();
        }
        return null;
    }


    public String codeGenerator(int length) {
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            code.append(character.charAt((int) (Math.random() * character.length())));
        }
        return code.toString();
    }


    private boolean validationUrl(String Url) {
        try {
            new URL(Url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
