package com.pravvich.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Pavel Ravvich.
 */
@Data
@Component
@ConfigurationProperties("limits.service")
public class Configuration {

    private int minimum;

    private int maximum;
}
