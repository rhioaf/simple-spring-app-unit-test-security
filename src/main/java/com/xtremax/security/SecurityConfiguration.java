package com.xtremax.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Autowired
  private UserAuthenticationProvider provider;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(provider);
  }

  @Configuration
  @Order(1)
  public static class NewsWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
          .authorizeRequests()
          .antMatchers("/css/**", "/js/**").permitAll()
          .antMatchers("/news/**").hasRole("USER")
          .and()
          .formLogin()
          .loginPage("/login")
          .permitAll()
          .and()
          .logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .permitAll();
    }
  }

  public static class ApiWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
          .antMatcher("/admin/**")
          .authorizeRequests()
          .anyRequest().hasRole("ADMIN")
          .and()
          .httpBasic();
    }
  }
}
