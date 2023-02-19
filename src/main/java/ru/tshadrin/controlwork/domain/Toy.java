package ru.tshadrin.controlwork.domain;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return id.equals(toy.id) && name.equals(toy.name) && weight.equals(toy.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight);
    }
}
