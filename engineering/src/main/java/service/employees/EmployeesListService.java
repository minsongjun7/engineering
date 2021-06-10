package service.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.EmployeesDTO;
import repository.EmployeesRepository;

public class EmployeesListService {
	@Autowired
	EmployeesRepository employeesRepository;
	public void empList(Model model) {
		List<EmployeesDTO> list = employeesRepository.empAllList();
		model.addAttribute("empList", list);
	}
}