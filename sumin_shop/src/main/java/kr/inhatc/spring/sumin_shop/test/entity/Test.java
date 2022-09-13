package kr.inhatc.spring.sumin_shop.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// entity에는 id가 필수
@Entity
@Data // 한번에 lombok에있는 애들 다 만들어줌 getter, setter등
public class Test {
  // 자바는 카멜케이스지만 db는 스네이크 케이스로 자동으로 이루어짐 그러니까 자바에서 스네이크케이스로 쓰지말기
  @Id // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Id 값을 자동 증가  - mysql는 indentity
  private long id;

  @Column(name = "name", nullable = false, length = 20) // 어노테이션 우선 myName으로 안됨, nullable은 null을 허용할지 말지, length 크기
  private String myName;

  private int myAge;

  // private String myInfo; - 알아서 삭제 - > update는 삭제, 변경 잘 안됨
}
