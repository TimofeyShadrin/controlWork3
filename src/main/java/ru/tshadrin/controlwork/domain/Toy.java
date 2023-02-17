package ru.tshadrin.controlwork.domain;

import java.util.concurrent.atomic.AtomicLong;

public class Toy {
    private static final AtomicLong aLong = new AtomicLong(0);
    private Long id;
    private String name;
    private Double weight;

    public Toy() {
        this.id = aLong.getAndIncrement();
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

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
