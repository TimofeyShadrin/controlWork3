package ru.tshadrin.controlwork.utils.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import org.springframework.stereotype.Service;
import ru.tshadrin.controlwork.dto.ToyDto;
import ru.tshadrin.controlwork.utils.ToyDtoService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToyDtoServiceImpl implements ToyDtoService {
    private final ObjectMapper mapper;

    public ToyDtoServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void writeResult(ToyDto dto) {
        File file = new File("result.json");
        mapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        List<ToyDto> dtoList;
        try {
            if (file.exists()) {
                try {
                    dtoList = mapper.readValue(file, new TypeReference<>() {
                    });
                } catch (IOException e) {
                    dtoList = new ArrayList<>();
                }
            } else {
                dtoList = new ArrayList<>();
            }
            dtoList.add(dto);
            FileWriter fileWriter = new FileWriter(file, false);
            SequenceWriter sequenceWriter = mapper.writer().writeValuesAsArray(fileWriter);
            for (ToyDto toyDto : dtoList) {
                sequenceWriter.write(toyDto);
            }
            sequenceWriter.close();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
