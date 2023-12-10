package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // 允许跨域的路径
                    .allowedOriginPatterns("*") // 允许跨域请求的域名
                    .allowedMethods("*") // 允许的请求方法
                    .allowCredentials(true) // 是否允许证书（cookies）
                    .maxAge(8000); // 预检请求的缓存时间（秒）
        }
}
