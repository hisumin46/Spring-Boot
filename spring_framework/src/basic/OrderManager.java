package basic;

public class OrderManager {
  private KiaMaker maker;

  public OrderManager() {
    maker = new KiaMaker();
  }

  public void order() {
    Money money = new Money(1000);
    System.out.println("판매상 (지불) :  "  + money.getAmout());

    Car car = maker.sell(money);
    System.out.println("판매상 : (인수)" + car.getName());
  }

  
}
