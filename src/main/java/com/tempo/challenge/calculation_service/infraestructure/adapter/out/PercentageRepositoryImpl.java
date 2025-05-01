package com.tempo.challenge.calculation_service.infraestructure.adapter.out;

import com.tempo.challenge.calculation_service.domain.port.PercentageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Repository
public class PercentageRepositoryImpl implements PercentageRepository {

    @Override
    public BigDecimal getCurrentPercentage() {
        return null;
    }
}
