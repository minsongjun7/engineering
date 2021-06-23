package service.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfo;
import model.PaymentDTO;
import repository.ProductRepository;

public class PaymentService {
	@Autowired
	ProductRepository productRepository;
	
	public void payment(String purNo, String payPrice, String payAccountNo, String payCardBank, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		PaymentDTO dto = new PaymentDTO();
		dto.setPayAccountNo(payAccountNo);
		dto.setPayCardBank(payCardBank);
		dto.setPayDate(payDate);
		dto.setPayMethod("카드");
		dto.setPayPrice(payPrice);
		dto.setPurNo(purNo);
		productRepository.payInsert(dto);
	}
}