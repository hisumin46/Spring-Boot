package kr.inhatc.spring.sumin_shop.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// entity는 디비 필드와 여러 엔티티간 연관관계를 정의하는걸로 한 행을 엔티티 객체라고 하고 테이블 전체를 엔티티라 부름
// 자바는 카멜케이스지만 db는 스네이크 케이스로 자동으로 이루어짐 그러니까 자바에서 스네이크케이스로 쓰지말기


// entity에는 id가 필수
@Entity
@Data // 한번에 lombok에있는 애들 다 만들어줌 getter, setter등
public class Test {

  @Id // PK 설정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Id 값을 자동 증가  - mysql는 indentity
  private long id;

  @Column(name = "name", nullable = false, length = 20) 
  // 어노테이션 우선 myName이 아닌 name으로 컬럼 생성
  // nullable은 null을 허용 여부
  // length 크기
  private String myName;
  
  private int myAge;
}
