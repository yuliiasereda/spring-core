package qualifiertask.service;

import org.springframework.stereotype.Service;

@Service
public class FirstService implements MyService {

  @Override
  public void print() {
    System.out.println("Print first service");
  }
}
