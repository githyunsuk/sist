package kr.co.sist.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.domain.Emp;
import kr.co.sist.dto.SearchDTO;
import kr.co.sist.service.EmpSearchService;

public class DbAction implements Action {

	private boolean forwardFlag;
	private String movePage;
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		forwardFlag = true;
		movePage = "/day0618/search_result.jsp";
		
		SearchDTO sDTO = new SearchDTO();
		sDTO.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		sDTO.setSal(Integer.parseInt(request.getParameter("sal")));
		
		EmpSearchService ess = new EmpSearchService();
		
		List<Emp> list = ess.searchEmp(sDTO);
		request.setAttribute("list", list);
	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

	@Override
	public String movePage() {
		return movePage;
	}

}
