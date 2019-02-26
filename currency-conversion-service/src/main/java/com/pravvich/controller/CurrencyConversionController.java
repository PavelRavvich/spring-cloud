package com.pravvich.controller;

import com.pravvich.model.CurrencyConversion;
import com.pravvich.service.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Pavel Ravvich.
 */
@RestController
public class CurrencyConversionController {

    private final CurrencyExchangeServiceProxy currencyExchangeService;

    @Autowired
    public CurrencyConversionController(CurrencyExchangeServiceProxy currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertFeign(
            @PathVariable final String from,
            @PathVariable final String to,
            @PathVariable final BigDecimal quantity) {

        final CurrencyConversion conversion = currencyExchangeService.getExchangeValue(from, to);

        assert conversion != null;
        conversion.setTotal(quantity.multiply(conversion.getConversion()));

        return conversion;
    }
}
