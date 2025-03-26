package kr.kh.tmp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;


import kr.kh.tmp.model.vo.UnitVO;

@Service
public class UnitServiceImp implements UnitService {

    private List<UnitVO> units;

    // 생성자에서 JSON 데이터 로드
//    public UnitServiceImp() {
//        this.units = loadUnits();
//    }

    // JSON 파일을 읽어와 List<UnitVO>로 변환
//    private List<UnitVO> loadUnits() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/unit_data.json")) {
//            return objectMapper.readValue(inputStream, new TypeReference<List<UnitVO>>() {});
//        } catch (IOException e) {
//            e.printStackTrace();
//            return List.of();
//        }
//    }

    @Override
    public List<UnitVO> getAllUnits() {
        return units;
    }
}
