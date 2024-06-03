package com.example.app.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * セキュリティの設定を管轄するクラス
 * @author yuki
 */
@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from users where user_id=?");
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// すべてのHTTPリクエストに対して認証を要求する
		http.authorizeHttpRequests(
				configurer -> configurer.requestMatchers("/") // ルートパスへのアクセスは"EMPLOYEE"ロールが必要
						.hasRole("EMPLOYEE")
						.requestMatchers("/leaders/**") // "/leaders/**"へのアクセスは"MANAGER"ロールが必要
						.hasRole("MANAGER")
						.requestMatchers("/systems/**") // "/systems/**"へのアクセスは"ADMIN"ロールが必要
						.hasRole("ADMIN")
						.anyRequest() // 上記以外のすべてのリクエストに対しては認証が必要
						.authenticated())

				// フォームのログイン設定
				.formLogin(
						form -> form.loginPage("/login") // カスタムログインページのパス
								.loginProcessingUrl("/authenticateTheUser") // ユーザ認証処理を担当するエンドポイント 
								.permitAll()) // ログインページへのアクセスは認証なしで許可
				.logout(logout -> logout.permitAll()) // ログアウトは認証なしで許可
				.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied")); // アクセス拒否で表示するページ

		// 構築されたHttpSecurityをSecurityFilterChainに組み立てて返す
		return http.build();
	}

}
