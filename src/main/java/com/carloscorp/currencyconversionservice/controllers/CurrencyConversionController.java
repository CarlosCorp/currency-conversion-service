package com.carloscorp.currencyconversionservice.controllers;

import com.carloscorp.currencyconversionservice.dto.CurrencyConversionResponseDTO;
import com.carloscorp.currencyconversionservice.services.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    @GetMapping("/from/{from}/to/{to}/{quantity}")
    public ResponseEntity<CurrencyConversionResponseDTO> getCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) throws Exception {

        return ResponseEntity.ok(currencyConversionService.getCurrencyConversionResponse(from,to,quantity));
    }
}
