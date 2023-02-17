package ru.tshadrin.controlwork.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.tshadrin.controlwork.service.ToyService;

class ToyServiceImplTest {
    private ToyService toyService;

    @BeforeEach
    void setUp() {
        toyService = new ToyServiceImpl();
    }

    @Test
    void getToy() {
        System.out.println(toyService.getToy());
    }
}