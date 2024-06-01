package com.example.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * セキュリティの設定を管轄するクラス
 * @author yuki
 */
@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated()).formLogin(
				form -> form.loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll())
				.logout(logout -> logout.permitAll());

		return http.build();
	}
}
