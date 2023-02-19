package ru.tshadrin.controlwork.service.impl;

import org.springframework.stereotype.Service;
import ru.tshadrin.controlwork.domain.Toy;
import ru.tshadrin.controlwork.exception.NoSuchToyException;
import ru.tshadrin.controlwork.service.ToyService;

import java.util.Objects;
import java.util.PriorityQueue;

@Service
public class ToyServiceImpl implements ToyService {
    private final PriorityQueue<Toy> storehouse;

    public ToyServiceImpl() {
        this.storehouse = new PriorityQueue<>(
                (o1, o2) -> {
                    if (Objects.equals(o1.getWeight(), o2.getWeight())) {
                        return (o2.getId()).compareTo(o1.getId());
                    }
                    return (o2.getWeight()).compareTo(o1.getWeight());
                }
        );
    }

    @Override
    public Toy putToy(String name, Double weight) {
        Toy toy = new Toy();
        toy.setName(name);
        toy.setWeight(weight);
        storehouse.add(toy);
        return toy;
    }

    @Override
    public Toy getToy() {
        if (storehouse.isEmpty()) {
            throw new NoSuchToyException("No toys in queue!");
        }
        return storehouse.poll();
    }
}
