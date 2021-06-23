package controller.prod;

import javax.annotation.RegEx;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsOrderCommand;
import command.ProductCommand;
import service.product.CartAddService;
import service.product.CartListService;
import service.product.CartQtyDownService;
import service.product.GoodsOrderService;
import service.product.PaymentService;
import service.product.ProdBuyService;
import service.product.ProductAutoNumService;
import service.product.ProductDeleteService;
import service.product.ProductInfoService;
import service.product.ProductJoinService;
import service.product.ProductListService;
import service.product.ProductModifyService;
import service.product.PurchaseListService;

@Controller
@RequestMapping("prod")
public class ProdController {
	@Autowired
	ProductAutoNumService productAutoNumService;
	@Autowired
	ProductJoinService productJoinService;
	@Autowired
	ProductListService productListService;
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	ProductModifyService productModifyService;
	@Autowired
	ProductDeleteService productDeleteService;
	@Autowired
	CartAddService cartAddService;
	@Autowired
	CartListService cartListService;
	@Autowired
	CartQtyDownService cartQtyDownService;
	@Autowired
	ProdBuyService prodBuyService;
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	PurchaseListService purchaseListService;
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("prodList")
	public String prodList(Model model) {
		productListService.prodList(model);
		return "product/productList";
	}
	@RequestMapping("prodJoin")
	public String prodJoin(Model model) {
		productAutoNumService.autoNum(model);
		return "product/productForm";
	}
	@RequestMapping("prodJoinOk")
	public String prodJoinOk(ProductCommand productCommand, HttpSession session) {
		productJoinService.prodJoin(productCommand, session);
		return "redirect:prodList";
	}
	@RequestMapping("prodUpdate")
	public String prodUpdate(@RequestParam(value="prodNo") String prodNo, Model model) {
		productInfoService.prodInfo(model, prodNo);
		return "product/prodModify";
	}
	@RequestMapping("prodModifyOk")
	public String prodModifyOk(ProductCommand productCommand) {
		productModifyService.prodUpdate(productCommand);
		return "redirect:prodList";
	}
	@RequestMapping("prodDel")
	public String prodDel(@RequestParam(value="prodNo") String prodNo, HttpSession session) {
		productDeleteService.prodDel(prodNo, session);
		return "redirect:prodList";
	}
	@RequestMapping("prodInfo")
	public String prodInfo(@RequestParam(value="prodNo") String prodNo, Model model) {
		productInfoService.prodInfo(model, prodNo);
		return "product/prodInfo";
	}
	@RequestMapping("cartAdd")
	public String cartAdd(@RequestParam(value="prodNo") String prodNo, @RequestParam(value="cartQty") String cartQty,
						  @RequestParam(value="prodPrice") String prodPrice, @RequestParam(value="catNum") String catNum,
						  Model model, HttpSession session) {
		cartAddService.cartAdd(prodNo, cartQty, prodPrice, catNum, session);
		return "redirect:cartList";
	}
	@RequestMapping("cartList")
	public String cartList(Model model, HttpSession session) {
		cartListService.cartList(model, session);
		return "product/cartList";
	}
	@RequestMapping("goodsCartQtyDown")
	public String goodsCartQtyDown(@RequestParam(value="prodNo") String prodNo, @RequestParam(value="prodPrice") String prodPrice,
								   HttpSession session) {
		cartQtyDownService.cartQtyDown(prodNo, prodPrice, session);
		return "redirect:cartList";
	}
	@RequestMapping("prodBuy")
	public String prodBuy(@RequestParam(value="prodCk") String [] prodCk, Model model, HttpSession session) {
		prodBuyService.prodBuy(session, prodCk, model);
		return "product/order";
	}
	@RequestMapping("goodsOrder")
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand, HttpSession session) {
		String purNo = goodsOrderService.goodsOrder(goodsOrderCommand, session);
		return "redirect:paymentOk?purNo="+purNo+"&payPrice="+goodsOrderCommand.getPurTotal();
	}
	@RequestMapping("purCon")
	public String purCon(HttpSession session, Model model) {
		purchaseListService.purchaseList(session, model);
		return "product/purCon";
	}
	@RequestMapping("paymentOk")
	public String paymentOk(@RequestParam(value="purNo") String purNo, @RequestParam(value="payPrice") String payPrice, Model model) {
		model.addAttribute("purNo", purNo);
		model.addAttribute("payPrice", payPrice);
		return "product/payment";
	}
	@RequestMapping("doPayment")
	public String doPayment(@RequestParam(value="purNo") String purNo, @RequestParam(value="payPrice") String payPrice,
							@RequestParam(value="payAccountNo") String payAccountNo, @RequestParam(value="payCardBank") String payCardBank,
							HttpSession session) {
		paymentService.payment(purNo, payPrice, payAccountNo, payCardBank, session);
		return "redirect:purCon";
	}
}