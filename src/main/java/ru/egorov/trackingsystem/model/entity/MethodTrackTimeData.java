package ru.egorov.trackingsystem.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MethodTrackTimeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String methodName;

    private String className;

    private String methodSignature;

    private Long executionTime;

    public MethodTrackTimeData(String methodName, String className, String methodSignature, Long executionTime) {
        this.methodName = methodName;
        this.className = className;
        this.methodSignature = methodSignature;
        this.executionTime = executionTime;
    }
}
