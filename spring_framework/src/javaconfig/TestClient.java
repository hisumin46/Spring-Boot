package javaconfig;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClient {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(CarConfig.class);
    OrderManager manager context.getBean("orderManager", OrderManager.class);
    manager.order();

    CarMaker maker = context.getBean("kiaCar", KiaMakker.class);
    manager.setMaker(maker);
    manager.order();

    
  }
}
