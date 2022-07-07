package com.soapman.config;

import com.soapman.filter.JwtAuthFilter;
import com.soapman.handler.AccessDeniedHandlerImpl;
import com.soapman.handler.AuthenticationEntryPointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity // 添加 security 过滤器
@EnableGlobalMethodSecurity(prePostEnabled = true)	// 启用方法级别的权限认证
public class SecurityConfig  {

    // jwt 校验过滤器，从 http 头部 token 字段读取 token 并校验
    @Resource
    private JwtAuthFilter jwtAuthFilter;

    // 认证异常提示处理
    @Resource
    private AuthenticationEntryPointImpl authenticationEntryPoint;

    // 鉴权异常提示处理
    @Resource
    private AccessDeniedHandlerImpl accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable() // 基于token，不需要 csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 基于token，不需要session
                //.exceptionHandling().authenticationEntryPoint(jwtAuthError).accessDeniedHandler(jwtAuthError).and() // 设置 jwtAuthError 处理认证失败、鉴权失败
                // 下面开始设置权限
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/login/in","/login/captcha.jpg","/doc.html", "/swagger-resources","/v3/api-docs", "/webjars/**").permitAll()// 请求放开
                        .anyRequest().authenticated()// 其他地址的访问均需验证权限
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) // 添加 JWT 过滤器，JWT 过滤器在用户名密码认证过滤器之前
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint) // 配置认证失败处理器
                .accessDeniedHandler(accessDeniedHandler).and() // 授权失败处理器
                .cors().and() // Security允许跨域
                .build();
    }

}
