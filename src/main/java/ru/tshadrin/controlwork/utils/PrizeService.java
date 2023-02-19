package ru.tshadrin.controlwork.utils;

import ru.tshadrin.controlwork.domain.Prize;
import ru.tshadrin.controlwork.domain.Toy;

public interface PrizeService {
    Prize getPrize(Toy toy);
}
