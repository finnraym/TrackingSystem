package ru.egorov.trackingsystem.model;

import lombok.Getter;

public record TrackTimeStatisticsInfo(String methodGroup, Long quantityOfCalls, Long executionTimeForAllTimes,
                                      Double averageExecutionTime) {

    public TrackTimeStatisticsInfo {
    }
}
