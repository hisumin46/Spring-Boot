package kr.inhatc.spring.sumin_shop.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.data.geo.Point;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inhatc.spring.sumin_shop.item.dto.ItemDto;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/thymeleaf")
public class ThymeleafController {
  @GetMapping("/ex1")
  // 컨트롤러에서 뷰단에 뭔가 보여주고 싶을땐 model을 만들기
  public String ex1(Model model) {
    Point p = new Point(10,20);
    // model.addAttribute("data", "나의 첫 thymeleaf");
    model.addAttribute("data", p);
    return "thymeleaf/ex1";
  }

  @GetMapping("/ex2")
  public String ex2(Model model) {
    ItemDto itemDto = new ItemDto();
    itemDto.setItemDetail("상품 상세 설명");
    itemDto.setItemName("테스트 상품1");
    itemDto.setPrice(10000);
    itemDto.setRegTime(LocalDateTime.now());
    
    model.addAttribute("itemDto", itemDto);
    
    return "thymeleaf/ex2";
  }


  @GetMapping("/ex3")
  public String ex3(Model model) {
    // 엘리먼트  E인 ItemDto
    List<ItemDto>  list = new ArrayList<>();
    
    for (int i = 1; i < 10; i++) {
      
      ItemDto itemDto = new ItemDto();
      itemDto.setItemDetail("상품 상세 설명" + i);
      itemDto.setItemName("테스트 상품" + i);
      itemDto.setPrice(10000 * i);
      itemDto.setRegTime(LocalDateTime.now());

      list.add(itemDto);
    }
    
    model.addAttribute("list", list);
    return "thymeleaf/ex3";
  }

  @GetMapping("/ex4")
  public String ex4(Model model) {
    // 엘리먼트  E인 ItemDto
    List<ItemDto>  list = new ArrayList<>();
    
    for (int i = 1; i < 10; i++) {
      
      ItemDto itemDto = new ItemDto();
      itemDto.setItemDetail("상품 상세 설명" + i);
      itemDto.setItemName("테스트 상품" + i);
      itemDto.setPrice(10000 * i);
      itemDto.setRegTime(LocalDateTime.now());

      list.add(itemDto);
    }
    
    model.addAttribute("list", list);
    return "thymeleaf/ex4";
  }

  @GetMapping("/ex5")
  public String ex5(String parm1, String parm2, Model model) {
  // public String ex5(@Param("param1")param1, Model model) {
    log.info("==> " + "ex5 호출");
    model.addAttribute("parm1", parm1);
    log.info("==> " + parm1);
    model.addAttribute("parm2", parm2);
    log.info("==> " + parm2);
    return "thymeleaf/ex5";
  }

  // @GetMapping("/ex6")
  // public String ex6() {
  //   return "thymeleaf/ex6";
  // }

  // @GetMapping("/ex7")
  // public String ex7() {
  //   return "thymeleaf/ex7";
  // }

  @GetMapping({"/ex6", "/ex7"})
  public void ex7() {
    // return "thymeleaf/ex7";
  }
}
