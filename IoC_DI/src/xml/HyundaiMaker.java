package xml;

public class HyundaiMaker implements CarMaker{
  public Car sell(Money money) {
    System.out.println("현대차 <입급>" + money.getAmout());

    Car car = new Car("쏘나타");
    
    System.out.println("현대차 <생산>" + car.getName());
    System.out.println("현대차 : <판매>" + car.getName());

    return car;
  }
}
