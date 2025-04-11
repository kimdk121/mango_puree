package com.mangopuree.support.config;

import com.mangopuree.support.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig implements WebMvcConfigurer {

    private final CustomUserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF 설정
        http.csrf((csrf) ->	csrf.disable())
                .authorizeHttpRequests((authorizedHttpRequests) ->
                        authorizedHttpRequests
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()// /static/css/** , /static/js/** , /static/images/** , /static/webjars/** , /static/favicon.*, /static/*/icon-*
                                .requestMatchers("/login/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll() //,"/templates/fragments/**"
                                .anyRequest().authenticated()
                ).formLogin((formLogin) ->
                        formLogin
                                .loginPage("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .loginProcessingUrl("/loginProcess")
                                //.defaultSuccessUrl("/login/loginSuccess.do")
                                .successHandler(new CustomAuthenticationSuccessHandler("/admin/main"))
                                //.failureUrl("/login/loginFail.do")
                                .failureHandler(new CustomAuthenticationFailureHandler("/login"))
                ).logout((logout) ->
                        logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutSuccessUrl("/login")
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider(userDetailsService , passwordEncoder());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SetUserIdInterceptor())
                .addPathPatterns("/api/**/insert/**","/api/**/update/**");
    }
}