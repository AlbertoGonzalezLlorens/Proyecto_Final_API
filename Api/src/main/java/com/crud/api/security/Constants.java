package com.crud.api.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String REGISTER_URL = "/register";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "admin";
	public static final String SUPER_SECRET_KEY = "1234";
	public static final long TOKEN_EXPIRATION_TIME = 259_000_000;

}