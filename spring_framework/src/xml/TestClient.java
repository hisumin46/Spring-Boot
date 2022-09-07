package xml;
import org.apache.catalina.core.ApplicationContext;

public class TestClient {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("car-config.xml");

    // OrderManager manager = new OrderManager(maker);  // xml이 동작하기 때문에 사용가능
    OrderManager manager = context.getBean("manager", OrderManager.class);  // xml이 동작하기 때문에 사용가능

    CarMaker maker = new HyundaiMaker();
    
    manager.order();
    
  }
}
