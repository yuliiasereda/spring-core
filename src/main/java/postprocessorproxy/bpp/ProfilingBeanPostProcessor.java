package postprocessorproxy.bpp;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import postprocessorproxy.mbean.ProfilerController;

@Component
public class ProfilingBeanPostProcessor implements BeanPostProcessor {

  private Map<String, Class> map = new HashMap<>(); //beanName - constant, bean.class name can be changed because of proxy
  private ProfilerController profilerController = new ProfilerController();


  public ProfilingBeanPostProcessor()
      throws Exception {
    MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
    platformMBeanServer
        .registerMBean(profilerController, new ObjectName("profiling", "name", "controller"));
  }

  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    Class<?> clazz = bean.getClass();
    if (clazz.isAnnotationPresent(Profiling.class)) {
      map.put(beanName, clazz); //saving original class
    }
    return bean;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    Class clazz = map.get(beanName); //retrieving original class name of annotated class
    if (clazz != null) {
      return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
          (proxy, method, args) -> {
            if (profilerController.isEnabled()) {
              System.out.println("Method is starting...");
              long start = System.currentTimeMillis();
              method.invoke(bean, args);
              long end = System.currentTimeMillis();
              System.out.println(end - start);
              System.out.println("Method is ending...");
            }
            return method.invoke(bean, args);
          });
    }
    return bean;
  }


}
