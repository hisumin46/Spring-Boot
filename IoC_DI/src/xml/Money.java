package xml;

/**
 * 돈을 관리하는 클래스
 * @author 김수민
 */
public class Money {
  private int amout; // 총 금액

  public int getAmout() {
    return this.amout; // 총 금액
  }

  public void setAmout(int amout) {
    this.amout = amout;
  }

  public Money() {
    super();
  }

  public Money(int amout) {
    super();
    this.amout = amout;
  }
  
  
}
