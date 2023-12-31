package in.co.vwits.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_employee")
public class Employee implements Comparable<Employee>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column(name="emp_name",nullable=false)
    private String name;
    private double salary;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
    @Override
	public int compareTo(Employee o) {		
		return (int) (o.salary - this.salary);
	}
}
