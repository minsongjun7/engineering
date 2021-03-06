package service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.CategoryDTO;
import repository.ProductRepository;

public class ProductAutoNumService {
	@Autowired
	ProductRepository productRepository;
	
	public void autoNum(Model model) {
		String autoNum = productRepository.autoNum();
		List<CategoryDTO> list = productRepository.catList();
		model.addAttribute("autoNum", autoNum);
		model.addAttribute("lists", list);
	}
}