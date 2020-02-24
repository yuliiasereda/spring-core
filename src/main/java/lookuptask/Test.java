package lookuptask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("lookuptask");
    SingletonBean bean = context.getBean(SingletonBean.class);
    for (int i = 0; i < 10; i++) {
      bean.doSmth();
    }
  }
}
