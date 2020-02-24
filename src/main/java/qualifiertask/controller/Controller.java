package qualifiertask.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import qualifiertask.service.MyService;

@Component
public class Controller {

  private MyService myService;

  public Controller(@Qualifier("firstService") MyService myService) {
    this.myService = myService;
  }

  public void doSmth() {
    myService.print();
  }
}
