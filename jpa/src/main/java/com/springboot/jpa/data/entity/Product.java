package com.springboot.jpa.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 클래스가 엔티티라는 것을 명시
@Table(name ="product") // 데이터베이스의 테이블 명시
public class Product {
  
  @Id // 테이블의 기본값설정으로 DB가 기본값을 생성하며 incremant
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long number;

  @Column(nullable = false) // 컬럼값 으로 null처리 불가능하게 설정
  private String name;

  @Column(nullable = false)
  private Integer price;

  @Column(nullable = false)
  private Integer stock;

  private LocalDateTime createAt;
  private LocalDateTime updataAt;
}
