package ru.egorov.trackingsystem.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO containing data on method execution time tracking")
public record TrackTimeDto(
        @Schema(description = "The string by which the data was grouped") String methodGroup,
        @Schema(description = "Number of calls for this sample") Long quantityOfCalls,
        @Schema(description = "Total execution time for this sample") Long executionTimeForAllTimes,
        @Schema(description = "Average execution time for this sample") Double averageExecutionTime) {
}
