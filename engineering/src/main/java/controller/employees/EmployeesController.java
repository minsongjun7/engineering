package controller.employees;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp")
public class EmployeesController {
	@RequestMapping("empList")
	public String empList() {
		return "employees/empList";
	}
}
