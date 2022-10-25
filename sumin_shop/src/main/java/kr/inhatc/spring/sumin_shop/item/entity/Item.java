package kr.inhatc.spring.sumin_shop.item.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import kr.inhatc.spring.sumin_shop.item.constant.ItemSellStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 상품을 관리하는 엔티티 클래스
 */
// 일반적으로 클래스와 필드는 넣는것이 기본
@Entity
@Table(name = "item") // 테이블 명칭 - 적지 않으면 디폴트 값은 클래스명으로 들어감
@Getter // 롬복에서 필드값의 대한 get 메소드와 set 메소드 가능 - set는 안만드는것이 좋다
@Setter
@NoArgsConstructor // 디폴트 생성자
@AllArgsConstructor // 모든 생성자 - 오류가 뜬다면 필드가 없어서 그렇다
@ToString // 문자열 출력 가능
public class Item {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가
  @Column(name = "item_id") // 컬럼명을 테이블의 필드값으로 하기
  private Long  id; // 아이디 - 상품 코드

  @Column(nullable = false, length = 50) // 컬럼 상세 정보세팅
  private String itemNm; // 상품명

  @Column(nullable = false)
  private int price; // 가격

  @Column(nullable = false)
  private int stockNumber; // 재고 수량

  @Lob // 여러가지 자료형을 받을 수 있게 함 큰파일을 다룰때? 가능
  @Column(nullable = false)
  private String itemDetail; // 상품 상세 설명

  // 불린 값이 아닌 만든 상수값으로 관리
  // 열거형을 String 타입으로 다루기 sell이나 soldout 인지 확인 같냐 비교할때 숫자인지 글자인지
    // EnumType.ORDINAL : enum 순서 값을 DB에 저장
  // EnumType.STRING : enum 이름을 DB에 저장
  @Enumerated(EnumType.STRING) 
  private ItemSellStatus itemSellStatus; // 상품 판매 상태

  @CreationTimestamp
  // @Temporal 로 하지만! localdatatime은 알아서 넣어줌
  private LocalDateTime regTime; // 등록한 시간

  @UpdateTimestamp
  private LocalDateTime UpdateTime; // 수정 시간

}