package uk.co.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.var;

/**
 * The purpose of this class is to essentially allow the application to start.
 * You can think of this as the root file if you like.
 *
 * @date 09/06/2020
 * @since 1.0.0
 * @author jo3-w3b-d3v
 */
@EnableWebMvc
@Configuration
@SpringBootApplication
@EnableWebSecurity
public class Application extends WebSecurityConfigurerAdapter {

	/**
	 * This is the starting point of this spring boot application.
	 *
	 * @since 1.0.0
	 * @param args
	 */
	public static void main(String[] args) {
		DispatcherServlet.class
		.cast(SpringApplication.run(Application.class, args).getBean("dispatcherServlet"))
				.setThrowExceptionIfNoHandlerFound(true);
	}

	/**
	 * This is used to configure the spring security.
	 * 
	 * @since 1.0.0
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable();
		
		// Security HTTP headers.
		http.headers()
				.cacheControl().and()
				.frameOptions().and()
				.xssProtection().and()
				.contentTypeOptions().and()
				.httpStrictTransportSecurity();
		
		// Set the session to be sate-less.
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// Allow all to hit the login end-point.
		http.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers("/v1/login")
				.permitAll();
		
		// Apply cors policies.
		http.cors()
				.configurationSource(corsConfigurationSource());
	}
	
	/**
	 * This method is responsible to applying the cors policies.
	 * 
	 * @since 1.0.0
	 * @return CorsConfigurationSource
	 */
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		var source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
