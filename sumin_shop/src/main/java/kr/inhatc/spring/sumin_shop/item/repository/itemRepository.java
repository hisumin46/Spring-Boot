package kr.inhatc.spring.sumin_shop.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.inhatc.spring.sumin_shop.item.entity.Item;

public interface itemRepository extends JpaRepository<Item, Long> {
  List<Item> findByItemName(String itemName); // 추상메소드이기 때문에 쿼리 끝
  
  List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);

  // @Query("select * from item") 이 아이템은 테이블이며 
  @Query("select i from Item as i where i.itemDetail like %:itemDetail% order by i.price asc") 
  // 엔티티 객체의 이름을 써야됨 as 별칭의 옵션이 아님 자바에서 쓰는걸 써야됨
  // : 은 파라미터로 지정해주며 @Param 으로 넘겨줌
  List<Item> findByItemDetail(@Param("itemDetail")String itemDetail);


  @Query(value = "select * from item i where i.item_detail like %:itemDetail% order by i.price asc", nativeQuery = true)  // 테이블명을 가져오기
  List<Item> findByItemDetailNative(@Param("itemDetail")String itemDetail);
}
