package xml;

public class HyundaiMaker implements CarMaker{
  // 돈을 받으면 자동차를 넘겨주는 함수
  @Override
  public Car sell(Money money) {
    System.out.println("현대차 <입급>" + money.getAmout());

    Car car = new Car("쏘나타");
    
    System.out.println("현대차 <생산>" + car.getName());
    System.out.println("현대차 : <판매>" + car.getName());

    return car;
  }
}
