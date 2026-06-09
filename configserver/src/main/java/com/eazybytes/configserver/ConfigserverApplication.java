package com.eazybytes.configserver;

import org.springframework.amqp.core.DeclarableCustomizer;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigServer
public class ConfigserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigserverApplication.class, args);
    }

    @Bean
    public DeclarableCustomizer queueCustomizer() {
        return declarable -> {
            if (declarable instanceof Queue queue) {
                queue.getArguments().remove("x-queue-master-locator");
            }
            return declarable;
        };
    }

}
