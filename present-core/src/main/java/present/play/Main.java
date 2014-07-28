package present.play;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Kos on 22.07.2014.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Starter starter = (Starter)applicationContext.getBean("Starter");
        starter.doProgram();
    }

}
