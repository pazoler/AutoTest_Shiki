package Autotest.hibernate.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

import static Autotest.stepDefinitions.base.DBHooks.factory;

public class BaseDBClass {

    public static boolean putIntoDB (DBInterface objectToPut) {

            try {
                Session session = factory.getCurrentSession();
                //открытие транзакции отправка и закрытие сессии
                session.beginTransaction();
                session.save(objectToPut);
                session.getTransaction().commit();
                return true;
            }
            catch (HibernateException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
    }



    public static DBInterface getFromDB (String className, int field) {
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            DBInterface object = (DBInterface) session.get(Class.forName(className), field);

//            session.getTransaction().commit();
            return object;
        }
        catch (HibernateException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

//    public static List<DBInterface> getFromDB (String className, String field, String value) {
//        try {
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            List<DBInterface> object = (List<DBInterface>) session.createQuery("from " + className + " where " + field +" ='" + value+"'");
//
////            session.getTransaction().commit();
//            return object;
//        }
//        catch (HibernateException e) {
//            throw new RuntimeException(e);
//        } catch (NumberFormatException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
