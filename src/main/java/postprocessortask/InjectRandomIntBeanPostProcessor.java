package postprocessortask;

import java.lang.reflect.Field;
import java.util.Random;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println("postProcessBEFOREInitialization METHOD");
    Field[] declaredFields = bean.getClass().getDeclaredFields();
    for (Field declaredField : declaredFields) {
      if (declaredField.isAnnotationPresent(InjectRandomInt.class)) {
        declaredField.setAccessible(true);
        InjectRandomInt annotation = declaredField.getAnnotation(InjectRandomInt.class);
        int min = annotation.min();
        int max = annotation.max();
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        ReflectionUtils.setField(declaredField, bean, randomNumber);
      }
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("postProcessAFTERInitialization METHOD");
    return bean;
  }
}
