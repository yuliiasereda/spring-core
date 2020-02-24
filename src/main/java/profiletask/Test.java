package profiletask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// mvn exec:java -Dexec.mainClass="profiletask.Test" -Dspring.profiles.active=local
public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("profiletask");
    Controller bean = context.getBean(Controller.class);
    bean.doSmth();
  }
}
