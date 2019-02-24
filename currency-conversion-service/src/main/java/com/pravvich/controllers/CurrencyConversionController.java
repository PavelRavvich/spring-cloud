package com.pravvich.controllers;

import com.pravvich.model.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author Pavel Ravvich.
 */
@RestController
public class CurrencyConversionController {

    private static final String URI_CURRENCY_EXCHANGE = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convert(
            @PathVariable final String from,
            @PathVariable final String to,
            @PathVariable final BigDecimal quantity) {

        final HashMap<String, String> uriVars = new HashMap<>();
        uriVars.put("from", from);
        uriVars.put("to", to);

        final CurrencyConversion conversion = new RestTemplate()
                .getForEntity(URI_CURRENCY_EXCHANGE, CurrencyConversion.class, uriVars)
                .getBody();

        conversion.setTotal(quantity.multiply(conversion.getConversion()));

        return conversion;
    }
}
