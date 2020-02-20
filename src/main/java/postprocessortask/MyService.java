package postprocessortask;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Getter
@Service
public class MyService implements InitializingBean {

  @InjectRandomInt(min=1, max=21)
  private int randomNumber;

  public MyService() {
    System.out.println("MY SERVICE CONSTRUCTOR");
  }

  @PostConstruct
  public void init(){
    System.out.println("INIT");
  }

  @PreDestroy
  public void destroy(){
    System.out.println("DESTROY");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("afterPropertiesSet");
  }
}
