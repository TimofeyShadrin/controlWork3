package ru.tshadrin.controlwork.utils.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.tshadrin.controlwork.domain.Prize;
import ru.tshadrin.controlwork.domain.Toy;
import ru.tshadrin.controlwork.utils.PrizeService;

import java.io.File;
import java.io.IOException;

@Service
public class PrizeServiceImpl implements PrizeService {

    private final ObjectMapper objectMapper;

    public PrizeServiceImpl() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public Prize getPrize(Toy toy) {
        File newFile = new File("prize.json");
        Prize prize;
        try {
            int chance = (int)(Math.random() * (100));
            if (chance < (toy.getWeight() * 100)) {
                prize = objectMapper.readValue(newFile, Prize.class);
            } else {
                prize = new Prize("Didn't win");
            }

        } catch (IOException ex) {
            prize = new Prize("No prizes today");
        }
        return prize;
    }
}
