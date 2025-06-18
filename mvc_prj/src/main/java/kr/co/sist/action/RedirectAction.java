package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.FormPreService;

public class RedirectAction implements Action {
   private boolean forwardFlag;
   private String movePage;
   
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      movePage="http://localhost/mvc_prj/index.html";
      
      //DB를 사용하지 않은 업무로직을 처리한 결과를 받아서 Form을 제공하는 JSP로 전달.
      FormPreService fps=new FormPreService();
      request.setAttribute("deptInfo", fps.deptInfo());
      request.setAttribute("today", fps.today());
      
   }//execute

   @Override
   public boolean isForward() {
      return forwardFlag;
   }//isForward

   @Override
   public String movePage() {
      return movePage;
   }//movePage

}//class
