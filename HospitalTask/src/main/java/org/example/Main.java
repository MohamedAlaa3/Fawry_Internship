package org.example;

import lombok.Data;
import org.hibernate.Session;


import javax.persistence.*;
import javax.print.Doc;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //JPA Start


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // Session session = entityManager.unwrap(Session.class);
        entityManager.getTransaction().begin();


        //entityManager.persist(employee);
        Doctor test = entityManager.find(Doctor.class, 1);
        System.out.println("name :: " + test.getName());
        System.out.println("Hello, World!");

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();


// hibernate start

//        Drug test = null;
//        Session session = null;
//
//        try {
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//            session.beginTransaction();
//
//
//
//
//
//
//
//
////            test = session.get(Drug.class, 1);
//
//            //All Doctors in the system
//            List<Doctor> doctorList = session.createQuery("FROM Doctor").list();
//           doctorList.forEach(element -> System.out.println(element.getName()));
//
//            // All Patients for  each doctor
//            doctorList.forEach(
//                    element -> {
//                        System.out.println("Doctor Name: " + element.getName());
//                        element.getPatints().forEach(
//                                patient -> System.out.println("Patient Name: " + patient.getName())
//                        );
//                    }
//            );
//
//
//
//            // all drugs for each doctor
//            doctorList.forEach(
//                    element -> {
//                        System.out.println("Doctor Name: " + element.getName());
//                        element.getPatints().forEach(
//                                p ->  p.getDrugs().forEach(
//                                        drug -> System.out.println("Drug Name: " + drug.getName())
//                                )
//                        );
//                    }
//            );


//
//            session.getTransaction().commit();
//            System.out.println("name :: " + test.getName());


//        } finally {
//            if (session != null)
//                session.close();
//        }
//    }


    }
}

