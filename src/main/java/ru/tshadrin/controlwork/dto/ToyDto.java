package ru.tshadrin.controlwork.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import ru.tshadrin.controlwork.annotation.NameAllowed;

public class ToyDto {
    private Long id;
    @NameAllowed(names = {"constructor", "robot", "doll"})
    private String name;
    @DecimalMax("1.0")
    @DecimalMin("0.0")
    private Double weight;

    public ToyDto(Long id, String name, Double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public ToyDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
