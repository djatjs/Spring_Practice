package kr.kh.tmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.tmp.service.UnitService;

@Controller
public class UnitViewController {
	
	@Autowired
    private UnitService unitService;

    public UnitViewController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/units")
    public String showUnits(Model model) {
        model.addAttribute("units", unitService.getAllUnits());
        return "units"; // units.jsp로 이동
    }
}