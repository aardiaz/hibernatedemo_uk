package com.model;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {
	
	public static void main(String[] args) {
		
		//oneToone();
		//oneTomany();
		//manyTomany();
		getAllEmp();
	}
	
	//oneToone
	static void oneToone() {
		
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session  sess = sf.openSession();
		sess.beginTransaction();
		
		Address adr = new Address(233, "Nepal", "ktm", "Bagmati");
		sess.save(adr);
		
		Employee  emp = new Employee(32, "Ram", "BC", 900000, adr);
		sess.save(emp);
		
		sess.getTransaction().commit();
		sess.close();
		 
	}
	
	//oneTomany
	
	static void oneTomany() {
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session  sess = sf.openSession();
		sess.beginTransaction();
		
		Address adr = new Address(233, "Nepal", "ktm", "Bagmati");
		sess.save(adr);
		
		Employee  emp = new Employee();
		emp.setFname("hari");
		emp.setLname("KC");
		emp.setAddress(adr);
		emp.setSalary(80000);
		
		Phone  p1 = new Phone();
		p1.setNumber("98513387");
		p1.setType("NTC");
		p1.setEmployee(emp);
		sess.save(p1);
		
		Phone  p2 = new Phone();
		p2.setNumber("980303878");
		p2.setType("NCELL");
		p2.setEmployee(emp);
		sess.save(p2);
		
		emp.setPhones(Arrays.asList(p1,p2));
		
		sess.save(emp);
		sess.getTransaction().commit();
		sess.close();
		
	}
	
	//manytomany
	static void manyTomany() {
		
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session  sess = sf.openSession();
		sess.beginTransaction();
		
		Address adr = new Address(233, "Nepal", "ktm", "Bagmati");
		sess.save(adr);
		
		Employee  emp = new Employee();
		emp.setFname("hari");
		emp.setLname("KC");
		emp.setAddress(adr);
		emp.setSalary(80000);
		
		Phone  p1 = new Phone();
		p1.setNumber("98513387");
		p1.setType("NTC");
		p1.setEmployee(emp);
		sess.save(p1);
		
		Phone  p2 = new Phone();
		p2.setNumber("980303878");
		p2.setType("NCELL");
		p2.setEmployee(emp);
		sess.save(p2);
		
		Department  d1 = new Department();
		d1.setName("IT");
		sess.save(d1);
		
		Department  d2  = new Department();
		d2.setName("Admin");
		sess.save(d2);
		
		emp.setDptList(Arrays.asList(d1,d2));
		emp.setPhones(Arrays.asList(p1,p2));
		
		sess.save(emp);
		sess.getTransaction().commit();
		sess.close();
	}
	
	static void getAllEmp() {
		
		SessionFactory  sf = new Configuration().configure().buildSessionFactory();
		Session  sess = sf.openSession();
		
		Criteria crt = sess.createCriteria(Employee.class);
		List<Employee>  empList = crt.list();
		
		 for(Employee e : empList) {
			 System.out.println("Fname= "+e.getFname());
			 System.out.println("LastName = "+e.getLname());
			 System.out.println("Country = "+e.getAddress().getCountry());
			List<Phone> plist = e.getPhones();
			 for(Phone p : plist) {
				 System.out.println("Number "+p.getNumber());
				 System.out.println("Type = "+p.getType());
			 }
			 
			 List<Department> dlist = e.getDptList();
			 for(Department p : dlist) {
				 System.out.println("Number "+p.getName());
			 }
		 }
	}

}
