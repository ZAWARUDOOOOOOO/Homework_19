package les.spring.events;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

public class MyEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public void publishEvent(int number, Locale locale) {
        context.publishEvent(new MyEvent(number, context, locale));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
