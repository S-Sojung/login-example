package shop.mtcoding.loginexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import shop.mtcoding.loginexample.interceptor.WebInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Interceptor 추가
        // registry.addInterceptor(new WebInterceptor())
        // // 아래의 URL은 인터셉터 적용X
        //
        registry.addInterceptor(new WebInterceptor())
                .excludePathPatterns("/css/**", "/fonts/**");
    }

}