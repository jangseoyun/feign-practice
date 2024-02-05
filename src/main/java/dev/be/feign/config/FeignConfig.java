package dev.be.feign.config;

import dev.be.feign.feign.logger.FeignCustomLogger;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    //logger는 전역 설정으로 본다
    @Bean
    public Logger feignLogger() {
        return new FeignCustomLogger();
    }
}
