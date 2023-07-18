package configure;

import hibernate_test.entity.ConnectionTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLTestIOC {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        ConnectionTest connectionTest = context.getBean("test",
                ConnectionTest.class);

        System.out.println(connectionTest);
        context.close();
    }
}
