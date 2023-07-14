package hibernate_test;

import hibernate_test.entity.ConnectionTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestRunner {
    public static void main(String[] args) {
        //живет долго - можно переиспользовать
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ConnectionTest.class)
                .buildSessionFactory();

        //создается и удаляется после использования


        try {
            Session session = factory.getCurrentSession();
            ConnectionTest emp = new ConnectionTest
                    ("Chel", "Animeshnik", "Anime", 1500);

            //открытие транзакции отправка и закрытие сессии
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
