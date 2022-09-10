package interfaces;

public class TestClient {
  public static void main(String[] args) {
    // CarMaker maker = new HyundaiMaker();
    CarMaker maker = new KiaMaker(); // 기아차로 선택시 인터페이스 구형이기때문에 여기서만 바꾸면 됨
    OrderManager manager = new OrderManager(maker); // 생성자로 세팅
    // manager.setMaker(maker); // setter로 세팅
    manager.order();

    
  }
}
