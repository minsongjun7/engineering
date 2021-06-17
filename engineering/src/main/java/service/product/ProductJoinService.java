package service.product;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import command.ProductCommand;
import model.AuthInfo;
import model.ProductDTO;

public class ProductJoinService {
	public void prodJoin(ProductCommand productCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String empNo = authInfo.getGrade();
		ProductDTO dto = new ProductDTO();
		dto.setCatNum(productCommand.getCatNum());
		dto.setEmpNo(empNo);
		dto.setProdInfo(productCommand.getProdInfo());
		dto.setProdName(productCommand.getProdName());
		dto.setProdNo(productCommand.getProdNo());
		dto.setProdPrice(productCommand.getProdPrice());
		//파일 처리
		String path = "WEB-INF/view/product/upload";
		String filePath = session.getServletContext().getRealPath(path);
		System.out.println(filePath);
		String prodImage = "";
		if(productCommand.getProdImage() != null) {
			//                       MultipartFile [] prodImage
			for(MultipartFile mf : productCommand.getProdImage()) {
				String original = mf.getOriginalFilename();
				//확장자 가져오기
				String originalExt = original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "")+originalExt;
				prodImage += store + ","; 
				//파일 저장
				File file = new File(filePath+"/"+store);
				try {
					mf.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		dto.setProdImage(prodImage);
	}
}