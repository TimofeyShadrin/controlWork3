package ru.tshadrin.controlwork.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tshadrin.controlwork.domain.Toy;
import ru.tshadrin.controlwork.dto.ToyDto;
import ru.tshadrin.controlwork.exception.NotBlankToyException;
import ru.tshadrin.controlwork.service.ToyService;

@RestController
@RequestMapping("/api/v1/toys")
public class AppController {

    private final ToyService toyServiceImpl;

    public AppController(ToyService toyServiceImpl) {
        this.toyServiceImpl = toyServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ToyDto> addToy(@Valid @RequestBody ToyDto dto) {
        if (dto.getWeight() == null) {
            throw new NotBlankToyException("Weight cannot be null");
        }
        Toy expected = toyServiceImpl.putToy(dto.getName(), dto.getWeight());
        return ResponseEntity.ok(new ToyDto(expected.getId(), expected.getName(), expected.getWeight()));
    }

    @GetMapping
    public ResponseEntity<ToyDto> getToy(){
        Toy temp = toyServiceImpl.getToy();
        return ResponseEntity.ok(new ToyDto(temp.getId(), temp.getName(), temp.getWeight()));
    }
}
