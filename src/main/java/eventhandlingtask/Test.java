package eventhandlingtask;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

  public static void main(String[] args) {
    ConfigurableApplicationContext context =
        new ClassPathXmlApplicationContext("eventhandling.xml");
    context.start();
    Message message = (Message) context.getBean("message");
    System.out.println(message);
    context.stop();
  }
}
