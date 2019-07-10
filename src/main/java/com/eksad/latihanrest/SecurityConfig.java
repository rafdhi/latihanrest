package com.eksad.latihanrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eksad.latihanrest.service.UsersService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UsersService usersService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
		.antMatchers("/user/**").hasAnyAuthority("ADMIN", "USER")
		.and().formLogin().permitAll().and().logout().logoutSuccessUrl("/login") ;
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest()
	 * .hasRole("USER").and() // Possibly more configuration ... .formLogin() //
	 * enable form based log in // set permitAll for all URLs associated with Form
	 * Login .permitAll(); }
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * String admin = "admin"; String adminPassword = encoder().encode("lohkoaku");
		 * 
		 * String user = "user"; String userPassword = encoder().encode("lohkouser");
		 * 
		 * auth.inMemoryAuthentication()
		 * .withUser(admin).password(adminPassword).roles("ADMIN","USER");
		 * 
		 * auth.inMemoryAuthentication()
		 * .withUser(user).password(userPassword).roles("USER");
		 */
		 
		auth.userDetailsService(usersService).passwordEncoder(encoder());
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
