package kr.inhatc.spring.sumin_shop.item.dto;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ItemDto {
  private Long  id; // 아이디 - 상품 코드

  private String itemNm; // 상품명

  private int price; // 가격

  private String itemDetail; // 상품 상세 설명

  private String sellStatCd; // 상품 판매 상태

  // @Temporal 로 하지만! localdatatime은 알아서 넣어줌
  private LocalDateTime regTime; // 등록한 시간

  private LocalDateTime UpdateTime; // 수정 시간
}
