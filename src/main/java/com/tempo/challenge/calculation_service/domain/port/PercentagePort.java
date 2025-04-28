package com.tempo.challenge.calculation_service.domain.port;

import java.math.BigDecimal;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-28
 * Role: Software Engineer
 * <p>
 * Domain port for retrieving the dynamic percentage used in calculation operations.
 */
public interface PercentagePort {

  /**
    * Retrieves the current dynamic percentage to apply in calculations.
    *
    * @return the percentage as a BigDecimal.
  */
  BigDecimal getCurrentPercentage();
}
