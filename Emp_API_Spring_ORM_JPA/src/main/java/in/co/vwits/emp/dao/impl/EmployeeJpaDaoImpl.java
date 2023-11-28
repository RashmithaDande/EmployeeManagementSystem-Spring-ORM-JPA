package in.co.vwits.emp.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import in.co.vwits.emp.dao.EmployeeDao;
import in.co.vwits.emp.model.Employee;

@Repository
public class EmployeeJpaDaoImpl implements EmployeeDao
{

	@PersistenceContext
	private EntityManager em;

	@Override
	public int save(Employee s) {
		em.persist(s);//It insterts record in db
		return 1;
	}

	@Override
	public Optional<Employee> findByEmpId(int rollno) {
		Employee e = em.find(Employee.class, rollno);
		return Optional.of(e);
	}

	@Override
	public List<Employee> findAll() {
	    String jpql = "FROM Employee";
	    TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
	    List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public void deleteByEmpId(int rollno) {
		em.remove(em.find(Employee.class,rollno));	
	}

	@Override
	public void updateByEmpId(Employee e) {
		em.merge(e);	
	}

}
