package lookupabstracttask;

import java.util.Random;

public class PrototypeBean {

  private int randomNumber;

  public PrototypeBean() {
    int min = 0;
    int max = 1000;
    Random random = new Random();
    randomNumber = random.nextInt((max - min) + 1) + min;
  }

  public int getRandomNumber() {
    return randomNumber;
  }
}
