package javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component // 객체로 올림
public class CarConfig { // 미리 객체를 만듦

  @Bean(name = "hyundai")
  public CarMaker hyudaiCar() {
    CarMaker make = new HyundaiMaker();
    return make;
  }
  
  @Bean // 이름이 없다면 메소드명 
  public CarMaker KiaCar() {
    CarMaker make = new KiaMaker();
    return make;
  }

  @Bean(name ="orderManager")
  public OrderManager orderManager() {
    OrderManager manager = new OrderManager(hyudaiCar());
    return manager;
  }
}
