package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Test {
	
	public static void main(String[] args) {
		//add();
		//getAll();
		//update();
		delete();
	}
	
	//add student
	static void add() {
		
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session  sess = sf.openSession();
		sess.beginTransaction();
		
		Student  s = new Student(234, "Chakra", "Lama", "IHIT", 34);
		sess.save(s);//insert sql
		
		sess.getTransaction().commit();//execute/fire
		sess.close();
	}
	
	//get All
	static void getAll() {
		
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session  sess = sf.openSession();
		
		Criteria  crt = sess.createCriteria(Student.class);
		  //crt.add(Restrictions.eq("college", "NCC"));
		  crt.add(Restrictions.le("age", 22));
		  
		List<Student>  slist = crt.list();
		
		System.out.println(slist);
		
	}
	
	
	//update 
	static void update() {
		
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session  sess = sf.openSession();
		sess.beginTransaction();
		
		Student s = (Student) sess.get(Student.class, 2);
		s.setAge(33);
		s.setCollege("NCIT");
		
		sess.update(s);
		sess.getTransaction().commit();
		sess.close();
		
	}
	
	//delete 
		static void delete() {
			
			SessionFactory  sf = new Configuration().configure().buildSessionFactory();
			Session  sess = sf.openSession();
			sess.beginTransaction();
			
			Student s = (Student) sess.get(Student.class, 2);
			 
			sess.delete(s);
			sess.getTransaction().commit();
			sess.close();
			
		}
	

}
