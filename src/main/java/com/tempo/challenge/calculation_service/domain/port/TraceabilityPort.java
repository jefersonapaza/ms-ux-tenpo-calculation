package com.tempo.challenge.calculation_service.domain.port;

import com.tempo.challenge.calculation_service.domain.model.TraceabilityRecord;

public interface TraceabilityPort {
    void save(TraceabilityRecord record);
}
