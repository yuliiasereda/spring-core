package beantask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beansconfig.xml");
    MessageService messageService = context.getBean(MessageService.class);
    messageService.printMessage();
  }
}
