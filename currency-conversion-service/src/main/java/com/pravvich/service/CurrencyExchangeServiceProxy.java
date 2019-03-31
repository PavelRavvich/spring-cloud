package com.pravvich.service;

import com.pravvich.model.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Pavel Ravvich.
 *
 * URL of service in application.properties by currency-exchange-service.ribbon.listOfServers=...
 * Its reqired with Ribbon load balancing overwise we can hardcode it inside FeignClient(uri=...)
 */
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

//    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
