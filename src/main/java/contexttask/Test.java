package contexttask;

import java.util.stream.Stream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("contextconfig.xml");
    Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    System.out.println("-----------------------------------------------------------------------------------------");


    context = new AnnotationConfigApplicationContext("contexttask/component");
    Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
  }
}
