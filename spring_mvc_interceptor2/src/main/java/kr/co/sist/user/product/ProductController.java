package kr.co.sist.user.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/user/product")
	public String productDetail() {
		return "product/prodDetail";
	}
}
