package kr.inhatc.spring.sumin_shop.item.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.inhatc.spring.sumin_shop.item.constant.ItemSellStatus;
import kr.inhatc.spring.sumin_shop.item.entity.Item;

@SpringBootTest
class itemRepositoryTest {

  @Autowired // 메모리에 올림
  itemRepository itemRepository;
  
  public void createItemList(){
    for(int i=1;i<=10;i++){
      Item item = new Item();
      item.setItemName("테스트 상품" + i);
      item.setPrice(10000 + i);
      item.setItemDetail("테스트 상품 상세 설명" + i);
      item.setItemSellStatus(ItemSellStatus.SELL);
      item.setStockNumber(100); item.setRegTime(LocalDateTime.now());
      item.setRegTime(LocalDateTime.now());
      Item savedItem = itemRepository.save(item);
    }
  }

  @Test
  @DisplayName("상품명 조회 테스트")
  public void findByItemNmTest(){
    this.createItemList();
    List<Item> itemList = itemRepository.findByItemName("테스트 상품1");
    for(Item item : itemList){
        System.out.println(item.toString());
    }
  }


  @Test
  @DisplayName("상품명, 상품상세설명 or 테스트")
  public void findByItemNameeOrItemDetailTest(){
      this.createItemList();
      List<Item> itemList = itemRepository.findByItemNameOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");
      for(Item item : itemList){
          System.out.println(item.toString());
      }
  }

  

  @Test
  @DisplayName("JPQL 사용하기") // 유니테스트에서 이름 정해주기
  public void findByItemDetailTest() {
    createItemList();
    List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명");
    for (Item item : itemList) {
      System.out.println(item);
    }
  }

  @Test
  @DisplayName("native 사용하기") // 유니테스트에서 이름 정해주기
  public void findByItemDetailNativeTest() {
    createItemList();
    List<Item> itemList = itemRepository.findByItemDetailNative("테스트 상품 상세 설명");
    for (Item item : itemList) {
      System.out.println(item);
    }
  }



  @Test
  void test() {
    Item item = new Item();
    System.out.println(item); // @toString 이 있기때문데 바로 출력 가능
  }

  @Test
  @DisplayName("상품 저장 테스트")
  public void createItemTest(){
      Item item = new Item();
      item.setItemDetail("테스트 상품");
      item.setPrice(10000);
      item.setItemDetail("테스트 상품 상세 설명");
      item.setItemSellStatus(ItemSellStatus.SELL);
      item.setStockNumber(100);
      item.setRegTime(LocalDateTime.now());
      item.setRegTime(LocalDateTime.now());
      Item savedItem = itemRepository.save(item);
      System.out.println(savedItem.toString());
  }
}
