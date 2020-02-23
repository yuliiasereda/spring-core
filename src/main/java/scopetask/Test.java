package scopetask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("scope.xml");
    Message message = (Message) context.getBean("message");
    message.setMessage("First object");
    System.out.println(message.getMessage());

    Message secondMessage = (Message) context.getBean("message");
    System.out.println(secondMessage.getMessage());
  }
}


//singletone (by default)
//Message: First object
//Message: First object

//prototype
//Message: First object
//Message: null
