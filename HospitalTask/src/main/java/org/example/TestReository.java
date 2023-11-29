//package org.example;
//
//import com.fawry.entities.Test;
//import com.fawry.util.HibernateUtil;
//import org.hibernate.Session;
//
//import java.util.List;
//
//public class TestReository {
//
//
//	public Test create(Test test) {
//
//		Session session = null;
//
//		try {
//			session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//			session.save(test);
//			session.getTransaction().commit();
//		} finally {
//			session.close();
//		}
//		return test;
//	}
//
//	public Test get(int testId) {
//
//		Test test = null;
//		Session session = null;
//
//		try {
//			session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//			test = session.get(Test.class, testId);
//			session.getTransaction().commit();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//		return test;
//	}
//
//	public List<Test> list() {
//
//		List<Test> tests = null;
//		Session session = null;
//
//		try {
//			session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//			tests = session.createQuery("from Test").getResultList();
//			session.getTransaction().commit();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//		return tests;
//	}
//
//	public Test update(Test newTest) {
//
//		Test test = null;
//		Session session = null;
//
//		try {
//			session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//			test = session.get(Test.class, newTest.getId());
//			test.setName(newTest.getName());
//			session.getTransaction().commit();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//		return test;
//	}
//
//	public Test delete(int testId) {
//
//		Test test = null;
//		Session session = null;
//
//		try {
//			session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//			test = session.get(Test.class, testId);
//			session.delete(test);
//			session.getTransaction().commit();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//		return test;
//	}
//
//}
