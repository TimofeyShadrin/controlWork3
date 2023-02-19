package ru.tshadrin.controlwork.domain;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Objects;

public class Prize {
    @JsonSetter("name")
    private String name;

    public Prize(String name) {
        this.name = name;
    }

    public Prize() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return name.equals(prize.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Prize{" +
                "name='" + name + '\'' +
                '}';
    }
}
