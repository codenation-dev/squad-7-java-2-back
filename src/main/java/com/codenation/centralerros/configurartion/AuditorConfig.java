package com.codenation.centralerros.configurartion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditorConfig {
	@Bean
	public CustomAuditorAware auditorProvider() {
		return new CustomAuditorAware();
	}
}
