package service.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.PurchaseListDTO;
import repository.ProductRepository;

public class PurchaseListService {
	@Autowired
	ProductRepository productRepository;
	
	public void purchaseList(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		List<PurchaseListDTO> list = productRepository.purList(membId);
		model.addAttribute("list", list);
	}
}