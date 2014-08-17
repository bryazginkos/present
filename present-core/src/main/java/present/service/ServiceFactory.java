package present.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import present.service.interfaces.StaticService;

/**
 * Created by Kos on 17.08.2014.
 */
public class ServiceFactory {

    public static StaticService getStaticServiceInstance(){
        return (StaticService)new ClassPathXmlApplicationContext("applicationContext.xml").getBean("StaticService");
    }
}
