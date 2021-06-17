package controller.prod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.product.ProductAutoNumService;

@Controller
@RequestMapping("prod")
public class ProdController {
	@Autowired
	ProductAutoNumService productAutoNumService;
	
	@RequestMapping("prodList")
	public String prodList() {
		return "product/productList";
	}
	@RequestMapping("prodJoin")
	public String prodJoin(Model model) {
		productAutoNumService.autoNum(model);
		return "product/productForm";
	}
}