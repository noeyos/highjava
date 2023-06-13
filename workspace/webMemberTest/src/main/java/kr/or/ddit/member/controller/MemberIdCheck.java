package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;


@WebServlet("/member/memberIdCheck.do")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String id = request.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		int cnt = service.getMemberCount(id);
		
		Gson gson = new Gson();
		String result = null;  
		
		if(cnt>0) { 
			result = gson.toJson("실패");
		} else {		
			result = gson.toJson("성공");
		}
		
		response.getWriter().write(result);
		response.flushBuffer();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
