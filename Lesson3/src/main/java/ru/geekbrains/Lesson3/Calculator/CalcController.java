package ru.geekbrains.Lesson3.Calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    @GetMapping("/calc_form")
    public String showCalcForm(@RequestParam(name = "var_a", required = false) Integer a, @RequestParam(name = "var_b", required = false) Integer b, @RequestParam(name = "result", required = false) Integer result){
        return "/WEB-INF/calc_form.html";
    }

    @GetMapping("/calc_result")
    public String sum(@RequestParam(name = "var_a") Integer a, @RequestParam(name = "var_b") Integer b) {
        Integer result = a + b;
        return "redirect:/" + String.format("calc_form?var_a=%d&var_b=%d&result=%d", a, b, result);
    }
}
