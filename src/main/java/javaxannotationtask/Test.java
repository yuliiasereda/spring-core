package javaxannotationtask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("javaxannotationtask");
    MessageService bean = context.getBean(MessageService.class);
    bean.printMessage();
  }
}
