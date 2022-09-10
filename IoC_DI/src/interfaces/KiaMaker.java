package interfaces;

public class KiaMaker implements CarMaker{
  public Car sell(Money money) {
    System.out.println("기아차 <입급>" + money.getAmout());

    Car car = new Car("K5");
    
    System.out.println("기아차 <생산>" + car.getName());
    System.out.println("기아차 자동차 : <판매>" + car.getName());
    return car;
  }
}
