package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLogin
 */
@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getCharacterEncoding();

		String userid = request.getParameter("id");
		String pass = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		if("admin".equals(userid)  && "1234".equals(pass)) {	// 로그인 성공	
			session.setAttribute("userID", userid);
		}
		
		response.sendRedirect(request.getContextPath() + "/basic/session/sessionLogin.jsp");
	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		session.setAttribute("id", "admin");
		session.setAttribute("pw", "1234");
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><head><meta charset='utf-8'><title>세션 로그인 연습</title></head>");
		out.println("<body>");
		out.println("<h2>"+ userid +"님 반갑습니다.</h2><br><br>");
		out.println("<a href='" + request.getContextPath() + 
				"/basic/session/sessionLogin.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
