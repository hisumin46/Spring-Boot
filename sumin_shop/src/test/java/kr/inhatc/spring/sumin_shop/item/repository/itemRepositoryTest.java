package kr.inhatc.spring.sumin_shop.item.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.inhatc.spring.sumin_shop.item.constant.ItemSellStatus;
import kr.inhatc.spring.sumin_shop.item.entity.Item;
// import kr.inhatc.spring.sumin_shop.item.entity.QItem;
import kr.inhatc.spring.sumin_shop.item.entity.QItem;




@SpringBootTest
class itemRepositoryTest {
  
  @PersistenceContext
  javax.persistence.EntityManager em;


  @Autowired // 메모리에 올림
  itemRepository itemRepository;
  
  // 상품 10개 만들기
  @Test
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


  @Test
  @DisplayName("Querydsl 조회 테스트1")
  public void querydslTest() {
    createItemList();

    JPAQueryFactory queryFactory = new JPAQueryFactory(em);
    
    // 객체 만드릭
    // QItem qItem = new QItem("m1");  // 구분 name 넣기
    QItem qItem = QItem.item;

    // queryFactory.select(qItem).from(qItem)
    List<Item> result = queryFactory
      .selectFrom(qItem)
      // .selectFrom(QItem.item) 위쪽에 statc으로 선언
      .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
      .where(qItem.itemDetail.like("%" + "테스트" + "%"))
      .orderBy(qItem.price.desc())
      .fetch();

      for (Item item : result){
        System.out.println(item);
      }
  }

  public void createItemList2(){
    for(int i=1;i<=5;i++){
        Item item = new Item();
        item.setItemName("테스트 상품" + i);
        item.setPrice(10000 + i);
        item.setItemDetail("테스트 상품 상세 설명" + i);
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        itemRepository.save(item);
    }

    for(int i=6;i<=10;i++){
        Item item = new Item();
        item.setItemName("테스트 상품" + i);
        item.setPrice(10000 + i);
        item.setItemDetail("테스트 상품 상세 설명" + i);
        item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
        item.setStockNumber(0);
        item.setRegTime(LocalDateTime.now());
        itemRepository.save(item);
    }
  }

  @Test
  @DisplayName("Querydsl 조회 테스트2")
  public void querydslTest2() {
    createItemList2();

    QItem item = QItem.item;
    String itmeDetail = "테스트";
    int price = 10003;
    String itemSellState = "SELL";

    BooleanBuilder booleanBuilder = new BooleanBuilder();
    booleanBuilder.and(item.itemDetail.like("%" + itmeDetail + "%"));
    booleanBuilder.and(item.price.gt(price));
    
    // 타임 리프에 있는거
    if(StringUtils.equals(itemSellState, ItemSellStatus.SELL)) {
      booleanBuilder.and(item.itemSellStatus.eq(ItemSellStatus.SELL));
    }

    // 페이지 처리인데 몇번부터 몇개까지
    // 한번에 가져오는것이 아닌 5개만 뽑아오는 것
    Pageable pageable = PageRequest.of(0, 5);
    Page<Item> result = itemRepository.findAll(booleanBuilder, pageable);

    System.out.println("total elements :" + result.getTotalElements());

    result.getContent();
    for (Item item2 : result) {
      System.out.println(item2);
    }
  }
}
