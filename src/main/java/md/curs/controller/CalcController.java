package md.curs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import md.curs.model.Calculator;
import md.curs.service.CalcService;

@Controller
@RequestMapping(value = "/calculator")
public class CalcController {
	
	@Autowired
	CalcService calcService;
	
	@GetMapping
	public String index(@ModelAttribute("calculator") Calculator calculator) {
		
		return "index";
	}
	
	@PostMapping
	public String calculate(@ModelAttribute("calculator") Calculator calcData, Model model) {
		
		String result = calcService.calculateResult(calcData);
		model.addAttribute("result", result);
		
		return "index";
	}
	
}
