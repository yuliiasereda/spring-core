package qualifiertask.controller;

import org.springframework.stereotype.Component;
import qualifiertask.service.MyService;

@Component
public class SecondController {

  private MyService secondService;

  public SecondController(MyService secondService) {
    this.secondService = secondService;
  }

  public void doSmth() {
    secondService.print();
  }
}
