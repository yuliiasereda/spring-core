package profiletask.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class RealService implements MyService {

  @Override
  public void print() {
    System.out.println("Print REAL service");
  }
}
