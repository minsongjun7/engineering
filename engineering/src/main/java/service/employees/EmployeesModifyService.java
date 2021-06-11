package service.employees;

import command.EmployeesCommand;
import model.EmployeesDTO;
import repository.EmployeesRepository;

public class EmployeesModifyService {
	@Autowired
	EmployeesRepository employeesRepository;
	public void empModify(EmployeesCommand employeesCommand) {
		EmployeesDTO dto = new EmployeesDTO();
		dto.setEmpNo(employeesCommand.getEmpNo());
		dto.setEmpDeptName(employeesCommand.getEmpDeptName());
		dto.setEmpEmail(employeesCommand.getEmpEmail());
		dto.setEmpPhoneNumber(employeesCommand.getEmpPhoneNumber());
		dto.setHireDate(employeesCommand.getHireDate());
		dto.setSalary(employeesCommand.getSalary());
		employeesRepository.empUpdate(dto);
	}
}