package listenertask;

import java.lang.reflect.Method;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {

  private ConfigurableListableBeanFactory factory;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    ApplicationContext context = contextRefreshedEvent.getApplicationContext();
    Stream.of(context.getBeanDefinitionNames()).map(s -> factory.getBeanDefinition(s)).map(
        s -> s.getBeanClassName()).map(s -> getAllMethods(s)).flatMap(Stream::of)
        .filter(s -> isAnnotationPostProxyPresent(s)).forEach(method -> {
      Class<?> declaringClass = method.getDeclaringClass();
      Object bean = context.getBean(declaringClass);
      Method currentMethod = null;
      try {
        currentMethod = bean.getClass()
            .getMethod(method.getName(), method.getParameterTypes());
        currentMethod.invoke(bean);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  private Method[] getAllMethods(String originalClassName) {
    Class<?> originalClass = null;
    try {
      originalClass = Class.forName(originalClassName);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return originalClass.getDeclaredMethods();
  }

  private boolean isAnnotationPostProxyPresent(Method method) {
    return method.isAnnotationPresent(PostProxy.class);
  }
}
