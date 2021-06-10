package service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeesCommand;
import model.EmployeesDTO;
import repository.EmployeesRepository;

public class EmployeesService {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	EmployeesRepository employeesRepository;
	public void insertEmp(EmployeesCommand employeesCommand) {
		EmployeesDTO dto = new EmployeesDTO();
		dto.setEmpDeptName(employeesCommand.getEmpDeptName());
		dto.setEmpEmail(employeesCommand.getEmpEmail());
		dto.setEmpId(employeesCommand.getEmpId());
		dto.setEmpName(employeesCommand.getEmpName());
		dto.setEmpNo(employeesCommand.getEmpNo());
		dto.setEmpPhoneNumber(employeesCommand.getEmpPhoneNumber());
		dto.setEmpPw(bCryptPasswordEncoder.encode(employeesCommand.getEmpPw()));
		dto.setHireDate(employeesCommand.getHireDate());
		dto.setSalary(employeesCommand.getSalary());
		employeesRepository.insertEmployees(dto);
	}
}