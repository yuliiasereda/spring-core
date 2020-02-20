package mixtask;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MessageService {

  @Value("${message}")
  private String message;
  private final FormattingService formattingService;

  public void printMessage() {
    System.out.println("Message: " + message);
    formattingService.printLine();
  }
}
