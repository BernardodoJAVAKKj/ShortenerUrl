package com.example.Url;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.*;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.UUID;


@SpringBootApplication


public class UrlApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrlApplication.class, args);
    }
}
