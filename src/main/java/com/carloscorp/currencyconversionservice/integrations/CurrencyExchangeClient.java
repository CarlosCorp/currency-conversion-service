package com.carloscorp.currencyconversionservice.integrations;


import com.carloscorp.currencyconversionservice.config.FeignConfig;
import com.carloscorp.currencyconversionservice.dto.ExchangeValueDto;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "currency-exchange-service", configuration = FeignConfig.class)
public interface CurrencyExchangeClient {

    @Retry(name = "exchange-client-config", fallbackMethod = "fallbackErrorMethod")
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ExchangeValueDto getExchangeValue(@PathVariable String from, @PathVariable String to);

    default ExchangeValueDto fallbackErrorMethod(Exception e){
        return new ExchangeValueDto("N/A","N/A", BigDecimal.valueOf(0),"offline");
    }
}
