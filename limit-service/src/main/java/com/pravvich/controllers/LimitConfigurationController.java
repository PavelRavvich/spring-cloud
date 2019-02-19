package com.pravvich.controllers;

import com.pravvich.configuration.Configuration;
import com.pravvich.model.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavel Ravvich.
 */
@RestController
public class LimitConfigurationController {

    private final Configuration configuration;

    @Autowired
    public LimitConfigurationController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public LimitConfiguration getLimitsConfiguration() {
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
