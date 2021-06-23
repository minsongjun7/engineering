package service.product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import command.GoodsOrderCommand;
import model.AuthInfo;
import model.CartDTO;
import model.PurchaseDTO;
import repository.ProductRepository;

public class GoodsOrderService {
	@Autowired
	ProductRepository productRepository;
	
	public void goodsOrder(GoodsOrderCommand goodsOrderCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		PurchaseDTO dto = new PurchaseDTO();
		dto.setMembId(membId);
		dto.setPurAddr(goodsOrderCommand.getPurAddr());
		dto.setPurMsg(goodsOrderCommand.getPurMsg());
		dto.setPurReceiverPhoneNumber(goodsOrderCommand.getPurReceiverPhoneNumber());
		dto.setPurTotal(goodsOrderCommand.getPurTotal());
		//purNo : 구매번호를 날짜로 사용
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purNo = df.format(new Date());
		dto.setPurNo(purNo);
		productRepository.purInsert(dto);
		String [] prodNums = goodsOrderCommand.getProdNums().split(",");
		for(String prodNum : prodNums) {
			//카트에 있는 제품정보를 구매리스트에 복사하기 위해서
			CartDTO d = new CartDTO();
			d.setPurNo(purNo);
			d.setMembId(membId);
			d.setProdNo(prodNum);
			productRepository.purListInsert(d);
		}
	}
}