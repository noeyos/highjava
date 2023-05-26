package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String calc = request.getParameter("calc");
		double sum = 0;
		boolean calcOk = true;	// 계산 성공 여부가 저장될 변수
		switch(calc) {
		case "+":
			sum = num1 + num2;
			break;
		case "-":
			sum = num1 - num2;
			break;
		case "*":
			sum = num1 * num2;
			break;
		case "/":
			if(num1==0 || num2 == 0) {
				calcOk=false;
			} else {
				sum = (double)num1 / num2;
			}
			break;
		case "%":
			if(num1==0 || num2 == 0) {
				calcOk=false;
			} else {
				sum = (double)num1 % num2;
			}
			break;
			
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Request연습</title></head>");
		out.println("<body>");
		out.println("<hr><h2>계산 결과</h2><hr>");
		out.println("<p> "
				+ num1 + calc + num2 + "=" + sum
				+ "</p>");
		
		if (calcOk) {
	         out.println(sum);
	      }else {
	         out.println("계산이 불가능합니다.");
	         out.println("0이 아닌 다른 숫자를 입력해주세요.");
	         
	      }
	      
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
