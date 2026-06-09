package com.eazybytes.loans.config;

import com.eazybytes.loans.dto.LoansContactInfoDto;
import org.springframework.amqp.core.DeclarableCustomizer;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LoansContactInfoDto.class)
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
