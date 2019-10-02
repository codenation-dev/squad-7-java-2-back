package com.codenation.centralerros.configurartion;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("squad7");
	}

    

}