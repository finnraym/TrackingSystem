package ru.egorov.trackingsystem.model.exception;

public class MethodTrackTimeNotFoundException extends RuntimeException {
    public MethodTrackTimeNotFoundException() {
        super("Method not found!");
    }
}
