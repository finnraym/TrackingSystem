package ru.egorov.trackingsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egorov.trackingsystem.model.entity.MethodTrackTimeData;
import ru.egorov.trackingsystem.model.exception.MethodTrackTimeNotFoundException;
import ru.egorov.trackingsystem.repository.MethodTrackTimeRepository;
import ru.egorov.trackingsystem.web.dto.TrackTimeDto;
import ru.egorov.trackingsystem.web.mapper.TrackTimeMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class TrackingAsyncTimeServiceImpl implements TrackingAsyncTimeService {

    private final MethodTrackTimeRepository repository;
    private final TrackTimeMapper mapper;
    @Async
    @Override
    @Transactional
    public void saveTrackingTimeForMethodName(MethodTrackTimeData data) {
        repository.save(data);
    }

    @Override
    public List<TrackTimeDto> getCommonStatistics() {
        return mapper.toListDto(repository.findAllGroupByMethodSignature());
    }

    @Override
    public TrackTimeDto getStatisticsByMethodName(String methodName) {
        return mapper.toDto(repository.findByMethodName(methodName)
                .orElseThrow(MethodTrackTimeNotFoundException::new));
    }

    @Override
    public TrackTimeDto getStatisticsByClassName(String className) {
        return mapper.toDto(repository.findByClassName(className)
                .orElseThrow(MethodTrackTimeNotFoundException::new));
    }

    @Override
    public TrackTimeDto getStatisticsByMethodSignature(String token) {
        return mapper.toDto(repository.findByContainsMethodSignature(token)
                .orElseThrow(MethodTrackTimeNotFoundException::new));
    }

}
