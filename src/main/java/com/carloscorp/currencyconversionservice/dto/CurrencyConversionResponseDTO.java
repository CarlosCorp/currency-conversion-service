package com.carloscorp.currencyconversionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionResponseDTO {

    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionResult;
    private String port;
}
