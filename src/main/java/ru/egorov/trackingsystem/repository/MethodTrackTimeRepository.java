package ru.egorov.trackingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.egorov.trackingsystem.model.entity.MethodTrackTimeData;
import ru.egorov.trackingsystem.model.TrackTimeStatisticsInfo;

import java.util.List;
import java.util.Optional;

public interface MethodTrackTimeRepository extends JpaRepository<MethodTrackTimeData, Long> {

    @Query("select new ru.egorov.trackingsystem.model.TrackTimeStatisticsInfo(td.methodSignature, count(*), sum(td.executionTime), avg(td.executionTime)) " +
            "from MethodTrackTimeData td " +
            "group by td.methodSignature")
    List<TrackTimeStatisticsInfo> findAllGroupByMethodSignature();

    @Query("select new ru.egorov.trackingsystem.model.TrackTimeStatisticsInfo(td.methodName, count(*), sum(td.executionTime), avg(td.executionTime)) " +
            "from MethodTrackTimeData td " +
            "where td.methodName = :methodName " +
            "group by td.methodName")
    Optional<TrackTimeStatisticsInfo> findByMethodName(String methodName);

    @Query("select new ru.egorov.trackingsystem.model.TrackTimeStatisticsInfo(td.className, count(*), sum(td.executionTime), avg(td.executionTime)) " +
            "from MethodTrackTimeData td " +
            "where td.className = :className " +
            "group by td.className")
    Optional<TrackTimeStatisticsInfo> findByClassName(String className);

    @Query("select new ru.egorov.trackingsystem.model.TrackTimeStatisticsInfo(:methodSignature, count(*), sum(td.executionTime), avg(td.executionTime)) " +
            "from MethodTrackTimeData td " +
            "where td.methodSignature like %:methodSignature%")
    Optional<TrackTimeStatisticsInfo> findByContainsMethodSignature(String methodSignature);
}
