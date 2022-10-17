package Assesment.assesment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class EmpController {
	
	@Autowired
	EmpService service;
	@RequestMapping("/")
	public String mainPage(Model model)
	{
		List<Employee> list = service.displayEmployee();
		for(Employee e : list)
		{
			System.out.println(e.getId()+" "+e.getName()+" "+e.getDesignation()+" "+e.getSalary());
		}
		model.addAttribute("abc",list);
		return "index";
	}
	@RequestMapping("/addData")
	public String newData(Model model)
	{
		service.addEmployee(model);
		return "addEmp";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAfter(@ModelAttribute("product") Employee employee)
	{
		service.saveEmployee(employee);
		return "redirect:/";
	}
	@RequestMapping("/update/{id}")
	public ModelAndView updateData(@PathVariable (name = "id") long id)
	{
		ModelAndView modelAndView = new ModelAndView("updateEmp");
		Employee employee = service.updateEmployee(id);
		modelAndView.addObject("emp", employee);
		return modelAndView;
	}
	@RequestMapping("/delete/{id}")
	public String editData(@PathVariable(name = "id")int id)
	{
		service.deleteEmployee(id);
		return "redirect:/";
	}
}
