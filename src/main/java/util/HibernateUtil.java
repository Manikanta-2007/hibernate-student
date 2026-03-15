package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Bike;
import entity.Car;
import entity.Course;
import entity.Department;
import entity.Employee;
import entity.Product;
import entity.Student;
import entity.Vehicle;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Department.class)
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Vehicle.class)
                    .addAnnotatedClass(Car.class)
                    .addAnnotatedClass(Bike.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}