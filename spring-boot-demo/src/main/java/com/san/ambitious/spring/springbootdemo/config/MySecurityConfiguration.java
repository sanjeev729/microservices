package com.san.ambitious.spring.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/public/**").hasRole("Normal")
                .antMatchers("/users/**").hasRole("Admin")
                .anyRequest().authenticated().and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sanjeev").password(this.passwordEncoder().encode("1234")).roles("Admin");
        auth.inMemoryAuthentication().withUser("sachin").password(this.passwordEncoder().encode("1234")).roles("Normal");
    }

    @Bean
    public BCryptPasswordEncoder  passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
