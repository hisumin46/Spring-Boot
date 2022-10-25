package kr.inhatc.spring.sumin_shop.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.inhatc.spring.sumin_shop.test.dto.TestDto;

// 메모리에 올리기 위해 컨트롤러 역할
// 데이터를 땡겨올거기 때문에 RestController 
// 만약 rest가 아닌 그냥 controller를 쓰면 경로에 해당하는 html을 찾음

@RestController
public class TestController {

  // @RequestMapping(value = "/", method = RequestMethod.GET)
  @GetMapping(value = "/") // GET 메소드로 hello url을 탔을때
  public String hello() {
    return "Hello World";
  }

  @GetMapping("/test")
  public TestDto test() {
    // TestDto dto = new TestDto();
    // dto.setAge(22);
    // dto.setName("김수민");
    // return dto; // 객체를 날렸으나 key :value 인 json 
    // 객체 타입으로 넘어감
    return new TestDto("김수민", 22);
  }
}
