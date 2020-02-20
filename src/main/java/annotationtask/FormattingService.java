package annotationtask;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FormattingService {
public void printLine(){
  System.out.println("----------------------");
}
}
