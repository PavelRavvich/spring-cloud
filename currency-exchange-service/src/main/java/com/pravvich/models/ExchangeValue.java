package com.pravvich.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Pavel Ravvich.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeValue {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversion;
}
