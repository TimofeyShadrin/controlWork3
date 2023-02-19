package ru.tshadrin.controlwork.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tshadrin.controlwork.domain.Prize;
import ru.tshadrin.controlwork.domain.Toy;
import ru.tshadrin.controlwork.dto.ToyDto;
import ru.tshadrin.controlwork.exception.NotBlankToyException;
import ru.tshadrin.controlwork.service.ToyService;
import ru.tshadrin.controlwork.utils.PrizeService;

@RestController
@RequestMapping("/api/v1/toys")
public class AppController {
    private final ToyService toyServiceImpl;
    private final PrizeService prizeServiceImpl;

    public AppController(ToyService toyServiceImpl, PrizeService prizeServiceImpl) {
        this.toyServiceImpl = toyServiceImpl;
        this.prizeServiceImpl = prizeServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ToyDto> addToy(@Valid @RequestBody ToyDto dto) {
        if (dto.getWeight() == null) {
            throw new NotBlankToyException("Weight cannot be null");
        }
        Toy expected = toyServiceImpl.putToy(dto.getName(), dto.getWeight());
        Prize prize = new Prize("The raffle will be executed upon receipt of toy");
        return ResponseEntity.ok(new ToyDto(expected.getId(), expected.getName(), expected.getWeight(), prize));
    }

    @GetMapping
    public ResponseEntity<ToyDto> getToy(){
        Toy temp = toyServiceImpl.getToy();
        Prize prize = prizeServiceImpl.getPrize(temp);
        return ResponseEntity.ok(new ToyDto(temp.getId(), temp.getName(), temp.getWeight(), prize));
    }
}
