package ru.egorov.trackingsystem.service;

import org.springframework.stereotype.Service;
import ru.egorov.trackingsystem.annotation.TrackAsyncTime;
import ru.egorov.trackingsystem.annotation.TrackTime;

@Service
public class SimpleServiceImpl implements SimpleService {

    @TrackAsyncTime
    @Override
    public void executeOne() {
        for (int i = 0; i < 1_000_000_000; i++) {

        }
    }

    @TrackTime
    @Override
    public void executeTwo() {
        for (int i = 0; i < 1_000_000; i++) {

        }
    }

    @TrackAsyncTime
    @Override
    public void executeThree() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
