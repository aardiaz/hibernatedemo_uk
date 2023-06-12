package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	private int salary;
	@OneToOne
	@JoinColumn(name = "addressId")//FK
	private Address address;
	
	@OneToMany(mappedBy = "employee")
	private List<Phone>  phones;
	
	@ManyToMany
	@JoinTable(name = "emp_dept", joinColumns = {@JoinColumn(name="empId")} , inverseJoinColumns = {@JoinColumn(name="deptId")} )
	private List<Department>  dptList;
	
	
	public List<Department> getDptList() {
		return dptList;
	}

	public void setDptList(List<Department> dptList) {
		this.dptList = dptList;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Employee() {}
	
	public Employee(int id, String fname, String lname, int salary, Address address) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", salary=" + salary + ", address="
				+ address + ", phones=" + phones + ", dptList=" + dptList + "]";
	}
	
	

}
