package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;

public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.memberMapper";
	private String statement;
	
	public void memberInsert(MemberDTO dto) {
		statement = namespace + ".memberInsert";
		sqlSession.insert(statement,dto);
	}
}