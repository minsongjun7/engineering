package controller.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.EmployeesCommand;
import service.employees.EmployeesDeleteService;
import service.employees.EmployeesInfoService;
import service.employees.EmployeesListService;
import service.employees.EmployeesModifyService;
import service.employees.EmployeesNoService;
import service.employees.EmployeesService;

@Controller
@RequestMapping("emp")
public class EmployeesController {
	@Autowired
	EmployeesService employeesService;
	@Autowired
	EmployeesNoService employeesNoService;
	@Autowired
	EmployeesListService employeesListService;
	@Autowired
	EmployeesInfoService employeesInfoService;
	@Autowired
	EmployeesModifyService employeesModifyService;
	@Autowired
	EmployeesDeleteService employeesDeleteService;
	
	@RequestMapping("empList")
	public String empList(Model model) {
		employeesListService.empList(model);
		return "employees/empList";
	}
	@RequestMapping("empRegister")
	public String empRegister(Model model) {
		employeesNoService.getEmpNo(model);
		return "employees/employeesForm";
	}
	@RequestMapping(value="empJoin", method=RequestMethod.POST)
	public String empJoin(EmployeesCommand employeesCommand) {
		employeesService.insertEmp(employeesCommand);
		return "redirect:empList";
	}
	@RequestMapping("/empInfo")
	public String empInfo(
			@RequestParam(value="empNo") String empNo, Model model) {
		employeesInfoService.empInfo(empNo, model);
		return "employees/employeesInfo";
	}
	@RequestMapping("empModify")
	public String empModify(
			@RequestParam(value="empNo") String empNo, Model model) {
		employeesInfoService.empInfo(empNo, model);
		return "employees/employeesModify";
	}
	@RequestMapping("empModifyOk")
	public String empModifyOk(EmployeesCommand employeesCommand) {
		employeesModifyService.empModify(employeesCommand);
		return "redirect:empInfo?empNo="+employeesCommand.getEmpNo();
	}
	@RequestMapping("empDelete")
	public String empDelete(
			@RequestParam(value="empNo") String empNo) {
		employeesDeleteService.empDelete(empNo);
		return "redirect:empList";
	}
}
