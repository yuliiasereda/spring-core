package lookuptask;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

  @Lookup
  PrototypeBean prototypeBean() {
    return null;
  }

  public void doSmth() {
    int number = prototypeBean().getRandomNumber();
    System.out.println("Number is " + number);
  }
}
