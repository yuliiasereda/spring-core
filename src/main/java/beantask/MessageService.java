package beantask;

import org.springframework.beans.factory.annotation.Value;

public class MessageService {

  @Value("${message}")
  private String message;

  private FormattingService formattingService;

  public MessageService(FormattingService formattingService) {
    this.formattingService = formattingService;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void printMessage() {
    System.out.println("Message: " + message);
    formattingService.printLine();
  }
}
