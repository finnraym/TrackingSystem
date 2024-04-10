package ru.egorov.trackingsystem.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.egorov.trackingsystem.service.TrackingAsyncTimeService;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Aspect
@Component
public class TrackAsyncTimeAspect extends BaseTrackTimeAspect {

    public TrackAsyncTimeAspect(TrackingAsyncTimeService trackingAsyncTimeService) {
        super(trackingAsyncTimeService);
    }

    @Pointcut("@annotation(ru.egorov.trackingsystem.annotation.TrackAsyncTime)")
    public void trackTimeAsyncPointcut() {}

    @Async
    @Around(value = "trackTimeAsyncPointcut()")
    public CompletableFuture<Object> around(ProceedingJoinPoint joinPoint) {
        log.info("Async aspect around method execution");
        return CompletableFuture.completedFuture(trackTimeForMethodSave(joinPoint));
    }
}

