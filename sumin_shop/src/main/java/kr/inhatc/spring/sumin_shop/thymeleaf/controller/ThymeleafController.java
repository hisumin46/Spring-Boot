package kr.inhatc.spring.sumin_shop.thymeleaf.controller;

import javax.xml.crypto.Data;

import org.springframework.data.geo.Point;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
  @GetMapping("/ex1")
  public String ex1(Model model) {
    Point p = new Point(10,20);
    // model.addAttribute("data", "나의 첫 thymeleaf");
    model.addAttribute("data", p);
    return "thymeleaf/ex1";
    // return "";
  }
}
