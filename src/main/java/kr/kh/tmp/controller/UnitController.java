package kr.kh.tmp.controller;

import kr.kh.tmp.service.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

//    @GetMapping("/units")
//    public String showUnits(Model model) {
//        model.addAttribute("units", unitService.getAllUnits());
//        return "units"; // units.jsp로 이동
//    }
}
