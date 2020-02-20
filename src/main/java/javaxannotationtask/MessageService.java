package javaxannotationtask;


import javaxannotationtask.FormattingService;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MessageService {

  private FormattingService formattingService;

  @Inject
  public void setFormattingService(@Named("formattingService")FormattingService formattingService) {
    this.formattingService = formattingService;
  }

  public void printMessage() {
    System.out.println("Message from MessageService");
    formattingService.printLine();
  }
}
