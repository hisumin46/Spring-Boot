package xml;

public class OrderManager {
  // private KiaMaker maker; 인터페이스 사용시 해당 maker를 하드코딩으로 만들필요 없음
  private CarMaker maker;

  // maker 세팅을 생성자로
  public OrderManager(CarMaker maker) {
    // maker = new KiaMaker(); //인터페이스 사용시 해당 maker를 하드코딩으로 만들필요 없음
    this.maker = maker;
  }

  // maker 세팅을 setter로
  // public void setMaker(CarMaker maker) {
  //   this.maker = maker;
  // }
  
  public void order() {
    Money money = new Money(1000);
    System.out.println("판매상 (지불) :  "  + money.getAmout());

    Car car = maker.sell(money);

    System.out.println("판매상 : (인수)" + car.getName());
  }





  
}
