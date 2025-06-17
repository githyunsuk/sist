package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	Web Parameter 처리, 관계유지, 이동할 방식, 응답할 페이지명 설정 
 */
public interface Action {
	
	/**
	 * Controller에서 호출할 method : Web Parameter 처리, 관계유지
	 * XxxService 클래스를 사용.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * 페이지 이동 방식
	 * true - forward / false - redirection
	 * @return boolean
	 */
	public boolean isForward();
	
	/**
	 * View 페이지명 반환
	 * @return String
	 */
	public String movePage();
}
