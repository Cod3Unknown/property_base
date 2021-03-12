package com.biye.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CrossDomainConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "OPTIONS")
                .maxAge(3600);

    }




    /**
     * 这里需要先将限流拦截器入住，不然无法获取到拦截器中的redistemplate
     * @return
     */
//    @Bean
//    public WeChatLoginInterceptor getWeChatLoginInterceptor() {
//        return new WeChatLoginInterceptor();
//    }

    public void addInterceptors(InterceptorRegistry registry) {

        //如果有多个拦截器，可以继续添加
//        registry.addInterceptor( getWeChatLoginInterceptor());

    }
}
