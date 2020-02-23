package listenertask;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

  private Map<String, Class> map = new HashMap<>(); //beanName - constant, bean.class name can be changed because of proxy

  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    Class<?> clazz = bean.getClass();
    map.put(beanName, clazz);
    return bean;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    Class clazz = map.get(beanName);
    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
        ((proxy, method, args) -> method.invoke(bean, args)));
  }
}
