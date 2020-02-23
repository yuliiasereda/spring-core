package postprocessorproxy;

import java.util.stream.Stream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import postprocessorproxy.service.MyService;

public class Test {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("postprocessorproxy");
    Stream.of(context.getBeanDefinitionNames()).forEach(System.out::print);

    MyService bean = context.getBean(MyService.class);
    System.out.println(bean.getClass());
    while (true) {
      bean.method();
    }
  }
}
