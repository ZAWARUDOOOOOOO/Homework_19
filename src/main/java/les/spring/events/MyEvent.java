package les.spring.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

public class MyEvent extends ApplicationEvent {

    private int number;
    private final ApplicationContext context;
    private Locale locale;

    public MyEvent(int number, ApplicationContext context, Locale locale) {
        super(number);
        this.number = number;
        this.context = context;
        this.locale = locale;
    }

    public int getNumber() {
        return number;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public Locale getLocale() {
        return locale;
    }
}
