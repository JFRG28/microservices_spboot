package com.eazybytes.cards.config;

import com.eazybytes.cards.dto.CardsContactInfoDto;
import org.springframework.amqp.core.DeclarableCustomizer;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CardsContactInfoDto.class)
public class AppConfig {

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
