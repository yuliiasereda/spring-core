package lookupabstracttask;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

  @Bean
  public SingletonBean getSingletonBean() {
    return new SingletonBean() {
      @Override
      public PrototypeBean prototypeBean() {
        return getPrototypeBean();
      }
    };
  }

  @Bean
  @Scope("prototype")
  public PrototypeBean getPrototypeBean() {
    return new PrototypeBean();
  }
}
