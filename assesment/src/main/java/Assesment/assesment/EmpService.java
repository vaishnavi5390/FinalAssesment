package Assesment.assesment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class EmpService {
	
	@Autowired
	EmpRepo  repo;
	
	public List<Employee> displayEmployee()
	{
		return repo.findAll();
	}
	public void addEmployee(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("emp", employee);
	}
	public void saveEmployee(Employee employee) 
	{
		repo.save(employee);
	}
	public Employee updateEmployee(long id)
	{
		return repo.findById(id).get();
	}
	public void deleteEmployee(long id)
	{
		repo.deleteById(id);
	}
	
}
