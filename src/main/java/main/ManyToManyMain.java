package main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Course;
import entity.Student;
import util.HibernateUtil;

public class ManyToManyMain {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Course c1 = new Course("Java");
        Course c2 = new Course("Hibernate");
        Course c3 = new Course("Spring");

        Student s1 = new Student("Manikanta");
        Student s2 = new Student("Rahul");

        s1.getCourses().add(c1);
        s1.getCourses().add(c2);

        s2.getCourses().add(c2);
        s2.getCourses().add(c3);

        c1.getStudents().add(s1);

        c2.getStudents().add(s1);
        c2.getStudents().add(s2);

        c3.getStudents().add(s2);

        session.save(s1);
        session.save(s2);

        tx.commit();
        session.close();

        System.out.println("Many-to-Many Mapping Done Successfully");
        HibernateUtil.getSessionFactory().close();
    }
}