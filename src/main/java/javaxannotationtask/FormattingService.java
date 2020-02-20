package javaxannotationtask;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class FormattingService {
public void printLine(){
  System.out.println("----------------------");
}
}
