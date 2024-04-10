package ru.egorov.trackingsystem.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import ru.egorov.trackingsystem.model.entity.MethodTrackTimeData;
import ru.egorov.trackingsystem.service.TrackingAsyncTimeService;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public abstract class BaseTrackTimeAspect {

    private final TrackingAsyncTimeService trackingAsyncTimeService;

    public Object trackTimeForMethodSave(ProceedingJoinPoint joinPoint) {
        try {
            long start = System.currentTimeMillis();
            String methodName = joinPoint.getSignature().getName();
            String methodSignature = joinPoint.getSignature().toLongString();
            String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
            log.info("Track time for method {} in aspect", methodSignature);
            Object proceed = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("Method {} execute for {} ms", methodSignature, end - start);
            MethodTrackTimeData data = new MethodTrackTimeData(methodName, className, methodSignature, end - start);
            trackingAsyncTimeService.saveTrackingTimeForMethodName(data);
            return proceed;
        } catch (Throwable t) {
            log.error("Error! Throwable message {}", t.getMessage());
            return null;
        }
    }
}
