package qualifiertask.service;

import org.springframework.stereotype.Service;

@Service
public class SecondService implements MyService {

  @Override
  public void print() {
    System.out.println("Print second service");
  }
}
