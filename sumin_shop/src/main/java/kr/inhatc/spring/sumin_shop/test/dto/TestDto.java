package kr.inhatc.spring.sumin_shop.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO는 로직을 가지지 않는 순수한 데이터 객체(getter & setter 만 가진 클래스)
// 디비에 값을 넣을때 입력받아 dto에 넣고 전송 해당 dto 객체를 받은 서버가 dao 를 이용하여 디비 데이터 넣음
// 그렇기 때문에 getter setter 세팅을 해야됨

// @Data로 세팅하면 다 됨
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TestDto {
  private String name;
  private int age;
}
