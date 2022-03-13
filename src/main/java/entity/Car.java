package entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Car {

    private Long id;

    private String carModel;

    private LocalDateTime creationDate;

    public Car(Long id, String carModel, LocalDateTime creationDate) {
        this.id = id;
        this.carModel = carModel;
        this.creationDate = creationDate;
    }
}
