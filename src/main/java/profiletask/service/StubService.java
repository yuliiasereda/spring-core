package profiletask.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class StubService implements MyService {

  @Override
  public void print() {
    System.out.println("Print STUB service");
  }
}
