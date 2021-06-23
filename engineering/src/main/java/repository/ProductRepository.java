package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.CartDTO;
import model.CategoryDTO;
import model.PaymentDTO;
import model.ProductCartDTO;
import model.ProductDTO;
import model.PurchaseDTO;
import model.PurchaseListDTO;

public class ProductRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.productMapper";
	private String statement;
	
	public String autoNum() {
		statement = namespace + ".autoNum";
		return sqlSession.selectOne(statement);
	}
	public List<CategoryDTO> catList() {
		statement = namespace + ".catList";
		return sqlSession.selectList(statement);
	}
	public void prodInsert(ProductDTO dto) {
		statement = namespace + ".prodInsert";
		sqlSession.insert(statement, dto);
	}
	public List<ProductDTO> prodAllList() {
		statement = namespace + ".prodList";
		return sqlSession.selectList(statement);
	}
	public ProductDTO prodInfo(String prodNo) {
		statement = namespace + ".prodInfo";
		return sqlSession.selectOne(statement, prodNo);
	}
	public void prodUpdate(ProductDTO dto) {
		statement = namespace + ".prodUpdate";
		sqlSession.update(statement, dto);
	}
	public void prodDel(String prodNo) {
		statement = namespace + ".prodDelete";
		sqlSession.delete(statement, prodNo);
	}
	public void cartAdd(CartDTO dto) {
		statement = namespace + ".cartInsert";
		sqlSession.insert(statement, dto);
	}
	public List<String> membCart(String membId) {
		statement = namespace + ".membCart";
		return sqlSession.selectList(statement, membId);
	}
	public ProductCartDTO cartList(CartDTO dto) {
		statement = namespace + ".cartList";
		return sqlSession.selectOne(statement, dto);
	}
	public void cartQtyDown(CartDTO dto) {
		statement = namespace + ".cartQtyDown";
		sqlSession.update(statement, dto);
	}
	public void purInsert(PurchaseDTO dto) {
		statement = namespace + ".purInsert";
		sqlSession.insert(statement, dto);
	}
	public void purListInsert(CartDTO dto) {
		statement = namespace + ".purListInsert";
		sqlSession.insert(statement, dto);
	}
	public void cartProdDel(CartDTO dto) {
		statement = namespace + ".cartProdDel";
		sqlSession.delete(statement, dto);
	}
	public List<PurchaseListDTO> purList(String membId) {
		statement = namespace + ".purList";
		return sqlSession.selectList(statement, membId);
	}
	public void payInsert(PaymentDTO dto) {
		statement = namespace + ".payInsert";
		sqlSession.insert(statement, dto);
	}
}