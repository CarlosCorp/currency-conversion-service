package com.carloscorp.currencyconversionservice.services;

import com.carloscorp.currencyconversionservice.dto.CurrencyConversionResponseDTO;

import java.math.BigDecimal;

public interface CurrencyConversionService {

    CurrencyConversionResponseDTO getCurrencyConversionResponse(String from,
                                                                String to,
                                                                BigDecimal quantity) throws Exception;
}
