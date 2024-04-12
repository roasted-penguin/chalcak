package com.penguin.chalcak.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ClovaOcrConfig {
    @Value("${clovaocr.key}")
    private String clientSecretKey;

    public String getClientSecretKey(){
        return clientSecretKey;
    }
}
