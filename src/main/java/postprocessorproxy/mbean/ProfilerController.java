package postprocessorproxy.mbean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProfilerController implements ProfilerControllerMBean {

  private boolean enabled = true;
}
