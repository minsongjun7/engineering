package controller.employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmployeesCommand;

@Controller
@RequestMapping("emp")
public class EmployeesController {
	@RequestMapping("empList")
	public String empList() {
		return "employees/empList";
	}
	@RequestMapping("empRegister")
	public String empRegister() {
		return "employees/employeesForm";
	}
	@RequestMapping(value="empJoin", method=RequestMethod.POST)
	public String empJoin(EmployeesCommand employeesCommand) {
		System.out.println(employeesCommand.getEmpId());
		return "redirect:empList";
	}
}
