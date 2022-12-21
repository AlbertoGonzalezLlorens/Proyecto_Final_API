package com.crud.api.security;

import static com.crud.api.security.Constants.LOGIN_URL;
import static com.crud.api.security.Constants.REGISTER_URL;

import java.util.Arrays;

import static com.crud.api.security.Constants.HOTELES_URL;
import static com.crud.api.security.Constants.HABITACIONES_URL;
import static com.crud.api.security.Constants.CONTACTO_URL;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public WebSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuración CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL,REGISTER_URL).permitAll()
			.antMatchers(HttpMethod.GET, HOTELES_URL,HABITACIONES_URL,CONTACTO_URL,"/api/hoteles/contactos/**"
					,"/api/hoteles/categoria/**","/api/hoteles/desayuno/**","/api/hoteles/precio/**","/api/habitaciones/hotel/**","/api/filtro/**").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "/**").authenticated()
	        .antMatchers(HttpMethod.GET,"/**").authenticated()
	        .antMatchers(HttpMethod.POST,"/**").authenticated()
	        .antMatchers(HttpMethod.PUT, "/**").authenticated()
	        .antMatchers(HttpMethod.DELETE,"/**").hasRole("admin")
			.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
		configuration.setAllowedHeaders(Arrays.asList("authorization","content-type","x-auth-token"));
		configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("*").allowedMethods("*").allowedMethods("*");
    }
}