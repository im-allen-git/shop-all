package com.akers.shopeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShopEureka {

    public static void main(String[] args) {
        SpringApplication.run(ShopEureka.class, args);
    }

}
