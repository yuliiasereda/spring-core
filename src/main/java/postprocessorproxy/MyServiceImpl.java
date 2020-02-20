package postprocessorproxy;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
@Profiling
public class MyServiceImpl implements MyService {

  public void method() {
    int min = 3;
    int max = 7;
    Random random = new Random();
    int randomNumber = random.nextInt((max - min) + 1) + min;
    try {
      System.out.println("MyServiceImpl method is working...");
      Thread.sleep(100 * randomNumber);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
