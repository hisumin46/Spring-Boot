package interfaces;

public interface CarMaker {
  public default Car sell(Money money) {
    return null;
  }
}
