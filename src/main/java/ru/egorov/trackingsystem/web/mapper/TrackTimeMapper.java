package ru.egorov.trackingsystem.web.mapper;

import org.mapstruct.Mapper;
import ru.egorov.trackingsystem.model.TrackTimeStatisticsInfo;
import ru.egorov.trackingsystem.web.dto.TrackTimeDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrackTimeMapper {

    TrackTimeDto toDto(TrackTimeStatisticsInfo info);

    List<TrackTimeDto> toListDto(List<TrackTimeStatisticsInfo> info);
}
