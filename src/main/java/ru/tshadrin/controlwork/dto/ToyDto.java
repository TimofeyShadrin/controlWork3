package ru.tshadrin.controlwork.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import ru.tshadrin.controlwork.annotation.NameAllowed;
import ru.tshadrin.controlwork.domain.Prize;

public class ToyDto {
    private Long id;
    @NameAllowed(names = {"constructor", "robot", "doll"})
    private String name;
    @DecimalMax("1.0")
    @DecimalMin("0.0")
    private Double weight;

    private Prize prize;

    public ToyDto(Long id, String name, Double weight, Prize prize) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.prize = prize;
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

    public Prize getPrize() {
        return prize;
    }

    public void setPrize(Prize prize) {
        this.prize = prize;
    }
}
