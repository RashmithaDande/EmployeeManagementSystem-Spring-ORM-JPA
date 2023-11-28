package in.co.vwits.emp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.vwits.emp.dao.EmployeeDao;
import in.co.vwits.emp.dao.impl.EmployeeJpaDaoImpl;
import in.co.vwits.emp.model.Employee;
import in.co.vwits.emp.service.EmployeeService;
import in.co.vwits.model.exception.EmployeeNotFoundException;

@Service //Used for annotation of service class
@Transactional //this annotation instructs spring framework to invoke all methods of this class in transaction
public class EmployeeServiceImpl implements EmployeeService {
	
	     //using reference of interface to communicate with other layer of application is known as "Coding to Interface".
         //"Coding to Interface" is best practice as it gives loose coupling among layers.
	     @Autowired
	     private EmployeeDao dao;
//	    
	    //sorting based on salary
	    @Override
	    public List<Employee> findAllEmployeesSortedBySalary(){
	    	return dao.findAll().stream().sorted().collect(Collectors.toList());
	    }
	    
	    @Override
	    //ReadAll
		public List<Employee>findAll(){
			return dao.findAll();
		}
		
	    @Override
		public void save(Employee e) {
			dao.save(e);
		}
	    
		public Optional<Employee> findByEmpId(int empId) throws EmployeeNotFoundException {
			Optional<Employee> p=dao.findByEmpId(empId);
			if(p.isPresent()) {
				return p;
			}
			else {
				
				throw new EmployeeNotFoundException();
			}

		}
		
		@Override
		public void deleteByEmpId(int rollno) {
			dao.deleteByEmpId(rollno);

		}
		
		@Override
		public void updateByEmpId(Employee e) { 
		  this.dao.updateByEmpId(e);
		  }
}
