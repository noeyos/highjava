package kr.or.ddit.member.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/member/memberUpdate.do")
@MultipartConfig
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVO vo = service.getMemberDetail(id);
		
		request.setAttribute("memberVo", vo);
		request.getRequestDispatcher("/WEB-INF/view/member/memberUpdateForm.jsp")
		.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadPath = "e:/d_other/member/uploadFiles";
		
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("mem_id");
		String pass = request.getParameter("mem_pass");
		String name = request.getParameter("mem_name");
		String tel = request.getParameter("mem_tel");
		String addr = request.getParameter("mem_addr");
		String oldPhoto = request.getParameter("old_photo");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_pass(pass);
		vo.setMem_name(name);
		vo.setMem_tel(tel);
		vo.setMem_addr(addr);
		vo.setMem_photo(oldPhoto); 
		
		Part part = request.getPart("mem_photo");
		
		if(part!=null) {
			String fileName = extractFilename(part);
			
			if(!"".equals(fileName)) {
				try {
					part.write(uploadPath + File.separator + fileName);
					
					vo.setMem_photo(fileName); 
				} catch (Exception e) {
					vo.setMem_photo(null);
				}
			}
		}
		
		IMemberService service = MemberServiceImpl.getInstance();
		service.updateMember(vo);
		
		response.sendRedirect(request.getContextPath()+"/member/memberList.do");

	}
	
	private String extractFilename(Part part) {
		String fileName = "";
		
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {  
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		return fileName;
	}

}












