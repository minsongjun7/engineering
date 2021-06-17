package controller.prod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("prod")
public class ProdController {
	@RequestMapping("prodList")
	public String prodList() {
		return "product/productList";
	}
	@RequestMapping("prodJoin")
	public String prodJoin() {
		return "product/productForm";
	}
}