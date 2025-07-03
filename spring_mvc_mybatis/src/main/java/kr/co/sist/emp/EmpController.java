package kr.co.sist.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {

	private final EmpService es;

	@Autowired(required = false)
	public EmpController(EmpService es) {
		this.es = es;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("deptnoList", es.searchAllDept());
		return "index";
	}

	@GetMapping("/searchDeptEmp")
	public String searchDeptEmp(int deptno, Model model) {

		model.addAttribute("deptno", deptno);
		model.addAttribute("empList", es.searchDeptEmp(deptno));

		return "emp/emp_list";
	}

	@PostMapping("/addEmp")
	public String addEmp(EmpDTO eDTO, Model model) {
		
		try {
			model.addAttribute("empResult", es.addEmp(eDTO));
		} catch(Exception e){
			e.printStackTrace();
			model.addAttribute("empResult", 0);
		}
		model.addAttribute("empData", eDTO);
		return "emp/addResult";
	}
}
