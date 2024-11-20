package com.carloscorp.currencyconversionservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.carloscorp.currencyconversionservice.*")
@Configuration
public class FeignConfig {

}
