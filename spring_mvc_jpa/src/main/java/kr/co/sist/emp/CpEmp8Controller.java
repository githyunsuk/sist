package kr.co.sist.emp;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CpEmp8Controller {

	@Autowired(required = false)
	private CpEmp8Service ces;

	@RequestMapping(value = "/", method = { GET, POST })
	public String index(Model model) {

		model.addAttribute("empList", ces.searchAllCpEmp8());

		return "index";
	}

	@GetMapping("/emp/empAddFrm")
	public String empAddFrm() {

		return "emp/empAddFrm";
	}

	@PostMapping({"/emp/empAddProcess", "/emp/empModifyProcess"})
	public String empAddFrmProcess(HttpServletRequest request, CpEmp8Entity cee, Model model) {
		// System.out.println(request.getRequestURI());

		String jobMsg = "추가";
		if ("/emp/empModifyProcess".equals(request.getRequestURI())) {
			jobMsg = "변경";
		}

		CpEmp8Entity ceResult = null;
		try {
			ceResult = ces.addModifyCpEmp8(cee);
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		

		model.addAttribute("jobMsg", jobMsg);
		model.addAttribute("ceResult", ceResult);

		return "emp/empAddResult";
	}
	
	@GetMapping("/emp/searchOneEmp")
	public String searchOneEmp(int empno, Model model) {
		
		CpEmp8Entity ceeResult = ces.searchOneEmp(empno);
		model.addAttribute("empData", ceeResult);
		
		return "emp/empDetail";
	}
	
	@PostMapping("/emp/removeEmp")
	public String removeEmp(int empno, Model model) {
		
		model.addAttribute("removeMsg", ces.removeCpEmp(empno)?"성공":"실패");
		model.addAttribute("empno", empno);
		
		return "emp/removeResult";
	}
	
}
