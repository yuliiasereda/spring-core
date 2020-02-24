package profiletask;

import org.springframework.stereotype.Component;
import profiletask.service.MyService;

@Component
public class Controller {

  private MyService myService;

  public Controller(MyService myService) {
    this.myService = myService;
  }

  public void doSmth() {
    myService.print();
  }
}
