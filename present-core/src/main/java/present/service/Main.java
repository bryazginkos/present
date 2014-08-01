package present.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Kos on 30.07.2014.
 */
public class Main {
    public static void main(String[] args) {
        TestDataCreater testDataCreater = (TestDataCreater)new ClassPathXmlApplicationContext("applicationContext.xml").getBean("TestDataCreater");
        testDataCreater.createData();
    }
}
