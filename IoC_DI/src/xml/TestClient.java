package xml;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {
  public static void main(String[] args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:car-config.xml"); // 자동으로 찾아주기

    OrderManager manager = context.getBean("manager", OrderManager.class);  // xml이 동작하기 때문에 사용가능    
    manager.order();

    // ((AbstractApplicationContext) context).close();
  }
}
