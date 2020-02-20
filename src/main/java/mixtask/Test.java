package mixtask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("mixconfig.xml");
    MessageService messageService = context.getBean(MessageService.class);
    messageService.printMessage();
    ((ClassPathXmlApplicationContext) context).close();
  }
}


//Configuration - property loads
//XML-bean initialization
//MessageService
//FormattingService
//XML-bean destroy