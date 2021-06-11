package service.employees;

import model.EmployeesDTO;
import repository.EmployeesRepository;

public class EmployeesInfoService {
	@Autowired
	EmployeesRepository employeesRepository;
	public void empInfo(String empNo, Model model) {
		EmployeesDTO dto = employeesRepository.empInfo(empNo);
		model.addAttribute("emp", dto);
	}
}