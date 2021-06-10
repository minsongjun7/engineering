package service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import repository.EmployeesRepository;

public class EmployeesNoService {
	@Autowired
	EmployeesRepository employeesRepository;
	public void getEmpNo(Model model) {
		int empNo = employeesRepository.getEmpNo();
		model.addAttribute("empNo1", empNo);
	}
}