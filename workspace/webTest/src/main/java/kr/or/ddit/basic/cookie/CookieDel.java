package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/cookieDel.do")
public class CookieDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// 방법1 : count를 1로 초기화
		// 방법2 : 쿠키 삭제 후 재생성
		
		// 쿠키이름: count로 한다
		
		// count라는 쿠키가 있는지 검사한다.
		Cookie[] cookieArr = request.getCookies();	// 전체 쿠키 가져오기
		int cnt = 0;	// 읽어온 count가 저장될 변수 // 방법1에서만 필요한 코드
		
		if(cookieArr!=null) {
			for(Cookie cookie : cookieArr) {
				if("count".equals(cookie.getName())) {	// count 이름의 쿠키가 있는지 검사
					String value = cookie.getValue();	// 쿠키값(현재의 count값) 구하기
					cnt = Integer.parseInt(value);	// 방법1에서만 필요한 코드
//					cookie.setMaxAge(0);			// 유지시간 0으로 설정해서 쿠키 삭제
//					response.addCookie(cookie);		// 쿠키 재생성
				} 
			}
		}
		
		cnt = 0;		// 카운트 0으로 초기화 // 방법1에서만 필요한 코드
		
		// 증가된 카운트값을 갖는 Cookie객체 생성
		Cookie countCookie = new Cookie("count", String.valueOf(cnt));	// 방법1에서만 필요한 코드
		// 쿠키 이름이 같으면 덮어씀
		
		response.addCookie(countCookie);	// 쿠키 추가
		
		
		out.println("<html><head><meta charset='utf-8'><title>쿠키 카운트 초기화</title></head>");
		out.println("<body>");
		out.println("<h2>Cookie Count가 초기화 되었습니다</h2><br><br>");
		out.println("<a href='" + request.getContextPath() + 
				"/basic/cookie/cookieTest02.jsp'>시작 문서로 이동하기</a>");
		out.println("</body></html>");

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
