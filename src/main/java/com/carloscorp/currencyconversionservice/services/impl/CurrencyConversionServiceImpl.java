package com.carloscorp.currencyconversionservice.services.impl;

import com.carloscorp.currencyconversionservice.dto.CurrencyConversionResponseDTO;
import com.carloscorp.currencyconversionservice.dto.ExchangeValueDto;
import com.carloscorp.currencyconversionservice.integrations.CurrencyExchangeClient;
import com.carloscorp.currencyconversionservice.services.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final CurrencyExchangeClient currencyExchangeClient;
    private final Environment environment;
    @Value("${services.currency-exchange-service.name:default}")
    private String instanceName;

    @Override
    public CurrencyConversionResponseDTO getCurrencyConversionResponse(String from, String to, BigDecimal quantity) throws Exception {

        ExchangeValueDto exchangeValue = currencyExchangeClient.getExchangeValue(from, to);
        if (exchangeValue.getEnvironment().equals("offline")){
            throw new Exception("Service offline");
        }
        BigDecimal totalAmount = quantity.multiply(exchangeValue.getConversionMultiple());

        String port = Optional.ofNullable(environment.getProperty("local.server.port"))
                .orElse(null);

        log.info(instanceName);

        return new CurrencyConversionResponseDTO(from, to, quantity, totalAmount, port);
    }
}
