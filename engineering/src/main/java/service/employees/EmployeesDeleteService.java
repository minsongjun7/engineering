package service.employees;

import org.springframework.beans.factory.annotation.Autowired;

import repository.EmployeesRepository;

public class EmployeesDeleteService {
	@Autowired
	EmployeesRepository employeesRepository;
	public void empDelete(String empNo) {
		employeesRepository.empDelete(empNo);
	}
}