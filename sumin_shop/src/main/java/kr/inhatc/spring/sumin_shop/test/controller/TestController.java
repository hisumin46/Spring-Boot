package kr.inhatc.spring.sumin_shop.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.sumin_shop.test.dto.TestDto;

// 메모리에 올리기 위해 컨트롤러 역할
// 데이터를 땡겨올거기 때문에 RestController 
// 웹사이트 이동은 Controller -
// 만약 rest가 아닌 그냥 controller를 쓰면 경로에 해당하는 html을 찾음
@RestController
public class TestController {
  // @RequestMapping(method = , "url")
  
  @GetMapping(value = "/")
  public String hello() {
    return "Hello World 123";
  }

  @GetMapping("/test")
  public TestDto test() {
    TestDto dto = new TestDto();
    dto.setAge(22);
    dto.setName("김수민");
    return dto; // 객체를 날렸으나 key :value 인 json 
  }
}
