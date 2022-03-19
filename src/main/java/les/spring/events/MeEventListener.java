package les.spring.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

import java.util.Locale;
import java.util.Random;

@Slf4j
public class MeEventListener implements ApplicationListener<MyEvent> {

    private final int lowerBound;
    private final int upperBound;
    private int randomNumber;

    public MeEventListener(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        randomNumber = new Random().nextInt(upperBound) + lowerBound;
    }

    @Override
    public void onApplicationEvent(MyEvent event) {
        Locale locale = event.getLocale();
        if (event.getNumber() < randomNumber) {
            log.info(event.getContext().getMessage("bigger.message", null, locale));
        } else if (event.getNumber() > randomNumber) {
            log.info(event.getContext().getMessage("less.message", null, locale));
        } else {
            log.info(event.getContext().getMessage("win.message", null, locale) + " " + randomNumber);
            randomNumber = new Random().nextInt(upperBound) + lowerBound;
            log.info(event.getContext().getMessage("hello.message", null, locale));
        }
    }
}
