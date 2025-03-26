package kr.kh.tmp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kh.tmp.model.vo.UnitVO;

@Service
public class UnitServiceImp implements UnitService {

    private final List<UnitVO> units;

    public UnitServiceImp() {
        this.units = loadUnits();
    }

    private List<UnitVO> loadUnits() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/unit_data.json")) {
            return objectMapper.readValue(inputStream, new TypeReference<List<UnitVO>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<UnitVO> getAllUnits() {
        return units;
    }
}