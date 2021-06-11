package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.EmployeesDTO;

public class EmployeesRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.employeesMapper";
	private String statement;
	
	public void empUpdate(EmployeesDTO dto) {
		statement = namespace + ".employeesUpdate";
	}
	public void insertEmployees(EmployeesDTO dto) {
		statement = namespace + ".employeesInsert";
		sqlSession.insert(statement, dto);
	}
	public EmployeesDTO empInfo(String empNo) {
		statement = namespace + ".empInfo";
		return sqlSession.selectOne(statement, empNo);
	}
	public int getEmpNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
	public List<EmployeesDTO> empAllList() {
		statement = namespace + ".empAllList";
		return sqlSession.selectList(statement);
	}
}