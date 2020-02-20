package postprocessortask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("postprocessortask");
    MyService myServiceBean = context.getBean(MyService.class);
    System.out.println("Random number is " + myServiceBean.getRandomNumber());
    ((AnnotationConfigApplicationContext) context).close();
  }
}

//MY SERVICE CONSTRUCTOR
//postProcessBEFOREInitialization METHOD
//INIT
//afterPropertiesSet
//postProcessAFTERInitialization METHOD
//Random number is 11
//DESTROY