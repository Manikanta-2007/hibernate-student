package main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Bike;
import entity.Car;
import util.HibernateUtil;

public class InheritanceMain {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Car car1 = new Car("Hyundai", 4);
        Car car2 = new Car("Honda", 2);

        Bike bike1 = new Bike("Yamaha", true);
        Bike bike2 = new Bike("Hero", false);

        session.save(car1);
        session.save(car2);
        session.save(bike1);
        session.save(bike2);

        tx.commit();
        session.close();

        System.out.println("Inheritance Mapping Done Successfully");
        HibernateUtil.getSessionFactory().close();
    }
}