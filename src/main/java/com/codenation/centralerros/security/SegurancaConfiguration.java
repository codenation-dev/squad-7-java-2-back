package com.codenation.centralerros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
public class SegurancaConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userService;

	private static final String[] PUBLIC_MATCHERS = {
			"/h2-console/**",
			"/log/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_SWAGGER = {
			"/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",

	};
    
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/user",
			"/auth/forgot",
	};
	
	

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        .antMatchers(HttpMethod.OPTIONS)
        .antMatchers(PUBLIC_MATCHERS)
        .antMatchers(PUBLIC_MATCHERS_SWAGGER)
        .antMatchers(PUBLIC_MATCHERS_GET);
    }

  
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
	
}