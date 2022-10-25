package kr.inhatc.spring.sumin_shop.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import kr.inhatc.spring.sumin_shop.item.entity.Item;

// ID로 저장한 PK, 자료형
// <S extends T> save(S entity) - 엔티티 저장 및 수정
// void delete(T entitiy) - 엔티티 삭제
// count() - 엔티티 총 개수 반환
// Iteravle<T> findall() - 모든 엔티티 조회
public interface ItemRepository extends JpaRepository<Item, Long>,  QuerydslPredicateExecutor<Item> { // 이러면 여기서도 qeurydsl 사용 가능
  List<Item> findByItemNm(String itemNm);
  List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

  // JPQL
  // @Query("select * from item") 이 아이템은 테이블이며 
  // 엔티티 객체의 이름을 써야됨 as 별칭의 옵션이 아님 자바에서 쓰는걸 써야됨
  // : 은 파라미터로 지정해주며 @Param 으로 넘겨줌
  @Query("select i from Item as i where i.itemDetail like %:itemDetail% order by i.price asc") 
  List<Item> findByItemDetail(@Param("itemDetail")String itemDetail);

  // native SQL
  // value 안에 쿼리문을 넣고 nativeQuery = true 지정
  @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price asc", nativeQuery = true)  
  List<Item> findByItemDetailNative(@Param("itemDetail")String itemDetail);
}
