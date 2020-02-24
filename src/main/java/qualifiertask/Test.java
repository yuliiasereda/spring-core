package qualifiertask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import qualifiertask.controller.Controller;
import qualifiertask.controller.SecondController;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("qualifiertask");
    Controller bean = context.getBean(Controller.class);
    bean.doSmth();
    SecondController secondController = context.getBean(SecondController.class);
    secondController.doSmth();
  }
}
