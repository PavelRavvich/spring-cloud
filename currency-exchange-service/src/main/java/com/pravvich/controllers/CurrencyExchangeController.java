package com.pravvich.controllers;

import com.pravvich.models.ExchangeValue;
import com.pravvich.repositories.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Pavel Ravvich.
 */
@RestController
public class CurrencyExchangeController {

    private final ExchangeValueRepository exchangeValueRepository;

    @Autowired
    public CurrencyExchangeController(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
