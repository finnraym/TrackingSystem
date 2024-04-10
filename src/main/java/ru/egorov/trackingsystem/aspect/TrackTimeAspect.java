package ru.egorov.trackingsystem.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.egorov.trackingsystem.service.TrackingAsyncTimeService;

@Slf4j
@Aspect
@Component
public class TrackTimeAspect extends BaseTrackTimeAspect{

    public TrackTimeAspect(TrackingAsyncTimeService trackingAsyncTimeService) {
        super(trackingAsyncTimeService);
    }

    @Pointcut("@annotation(ru.egorov.trackingsystem.annotation.TrackTime)")
    public void trackTimePointcut() {}


    @Around(value = "trackTimePointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        log.info("Aspect around method execution");
        return trackTimeForMethodSave(joinPoint);
    }
}
