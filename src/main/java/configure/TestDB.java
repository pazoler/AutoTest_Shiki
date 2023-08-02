package configure;

import Autotest.hibernate.entity.AnimesTable;
import Autotest.hibernate.entity.ConnectionTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestDB {
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
//            session.save(emp);
            List<ConnectionTest> tests = session.createQuery("from ConnectionTest", ConnectionTest.class).getResultList();
            System.out.println(tests);
            List<AnimesTable> tests1 = session.createQuery("from AnimesTable", AnimesTable.class).getResultList();
            System.out.println(tests1);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
