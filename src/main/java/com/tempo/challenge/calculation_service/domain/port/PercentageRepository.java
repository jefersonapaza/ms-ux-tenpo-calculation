package com.tempo.challenge.calculation_service.domain.port;

import reactor.core.publisher.Mono;

import java.math.BigDecimal;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-28
 * Role: Software Engineer
 * <p>
 * Domain port for retrieving the dynamic percentage used in calculation operations.
 */
public interface PercentageRepository {

  /**
    * Retrieves the current dynamic percentage to apply in calculations.
    *
    * @return the percentage as a BigDecimal.
  */
  Mono<BigDecimal> getCurrentPercentage();
}
