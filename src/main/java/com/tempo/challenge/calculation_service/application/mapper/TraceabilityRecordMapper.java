package com.tempo.challenge.calculation_service.application.mapper;

import com.tempo.challenge.calculation_service.application.dto.TraceabilityRecordResponseDto;
import com.tempo.challenge.calculation_service.domain.model.TraceabilityRecord;
import org.springframework.stereotype.Component;

@Component
public class TraceabilityRecordMapper {

    private TraceabilityRecordMapper() {
        // Utility class
    }

    public static TraceabilityRecordResponseDto toDto(TraceabilityRecord record) {
        return new TraceabilityRecordResponseDto(
                record.getNum1(),
                record.getNum2(),
                record.getPercentageApplied(),
                record.getResult(),
                record.getTimestamp()
                );
    }
}
