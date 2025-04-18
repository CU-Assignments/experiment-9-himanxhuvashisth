
package com.example;

import com.example.model.Student;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CrudApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Create
        Transaction tx = session.beginTransaction();
        Student student = new Student("John Doe", 22);
        session.save(student);
        tx.commit();

        // Read
        Student fetched = session.get(Student.class, student.getId());
        System.out.println("Fetched: " + fetched);

        // Update
        tx = session.beginTransaction();
        fetched.setAge(23);
        session.update(fetched);
        tx.commit();

        // Delete
        tx = session.beginTransaction();
        session.delete(fetched);
        tx.commit();

        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
