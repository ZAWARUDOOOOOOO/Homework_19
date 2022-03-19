package les.spring.beans;

import les.spring.events.MyEvent;
import les.spring.events.MyEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.PropertySources;

import java.util.Locale;
import java.util.Scanner;

@Slf4j
public class Test implements ApplicationContextAware {

    public ApplicationContext context;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");

        Locale locale = Locale.US;
        log.info(context.getMessage("hello.message", null, locale));

        while (true) {
            log.info(context.getMessage("try.message", null, locale));
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            context.getBean(MyEventPublisher.class).publishEvent(number, locale);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        System.out.println(applicationContext);
    }
}
