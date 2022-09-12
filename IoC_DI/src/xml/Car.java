package xml;

/**
 * 자동차 이름을 관리하는 클래스
 * @author 김수민
 */
public class Car {
  private String name; // 자동차 이름

  public Car() {
    super();
  }

  public Car(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
