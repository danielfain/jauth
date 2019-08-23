package dev.fain.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // disable csrf
    http.csrf().disable();

    // no sessions will be created since we are using jwt
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // allow login and signup without authorization, disallow everything else
    http.authorizeRequests()
      .antMatchers("/user/login").permitAll()
      .antMatchers("/user/signup").permitAll()
      .anyRequest().authenticated();

    // redirect to login if request is made without authorization  
    http.exceptionHandling().accessDeniedPage("/login");

  }

}