package nuc.txjg10.configuration;

import nuc.txjg10.interceptor.AddUserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: jurui
 * @Email: acescen@foxmail.com
 * @ProjectName: txjg10
 * @Package: nuc.txjg10.configuration
 * @Description:
 * @Date: Created in 14:58 2019-12-26
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，判断是否有 @addUser 注解
        registry.addInterceptor(addUserInterceptor()).addPathPatterns("/**");
    }


    @Bean
    public AddUserInterceptor addUserInterceptor() {
        return new AddUserInterceptor();
    }

}
