package com.pravvich.repositories;

import com.pravvich.models.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavel Ravvich.
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
