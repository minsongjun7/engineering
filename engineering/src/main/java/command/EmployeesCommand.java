package command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeesCommand {
	Long empNo;
	String empId;
	String empPw;
	String empPwCon;
	String empName;
	String empDeptName;
	String empEmail;
	String empPhoneNumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date hireDate;
	Long salary;
	
	public Long getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public String getEmpPwCon() {
		return empPwCon;
	}
	public void setEmpPwCon(String empPwCon) {
		this.empPwCon = empPwCon;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDeptName() {
		return empDeptName;
	}
	public void setEmpDeptName(String empDeptName) {
		this.empDeptName = empDeptName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPhoneNumber() {
		return empPhoneNumber;
	}
	public void setEmpPhoneNumber(String empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public boolean isEmpPwEqualsEmpPwCon() {
		if(empPw.equals(empPwCon)) {
			return true;
		}
		else {
			return false;
		}
	}
}