package kr.kh.tmp.model.vo;

import java.util.List;

import lombok.Data;

@Data
public class UnitVO {
    private String id;
    private String name;
    private int cost;
    private List<String> traits;
    private String image;

    // 기본 생성자
    public UnitVO() {}

    // 모든 필드를 포함하는 생성자
    public UnitVO(String id, String name, int cost, List<String> traits, String image) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.traits = traits;
        this.image = image;
    }
}
