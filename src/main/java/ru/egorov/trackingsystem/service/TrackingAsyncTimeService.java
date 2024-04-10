package ru.egorov.trackingsystem.service;

import ru.egorov.trackingsystem.model.entity.MethodTrackTimeData;
import ru.egorov.trackingsystem.web.dto.TrackTimeDto;

import java.util.List;

public interface TrackingAsyncTimeService {

    void saveTrackingTimeForMethodName(MethodTrackTimeData data);

    List<TrackTimeDto> getCommonStatistics();

    TrackTimeDto getStatisticsByMethodName(String methodName);

    TrackTimeDto getStatisticsByClassName(String className);

    TrackTimeDto getStatisticsByMethodSignature(String token);

}
