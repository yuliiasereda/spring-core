package listenertask;

import org.springframework.stereotype.Service;

@Service
public class MyService {

  @PostProxy
  public void prepare() {
    System.out.println("Preparing...");
  }
}
