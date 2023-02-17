package ru.tshadrin.controlwork.service;

import ru.tshadrin.controlwork.domain.Toy;

public interface ToyService {
    Toy putToy(String name, Double weight);
    Toy getToy();
}
