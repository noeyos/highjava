package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberSerivceImpl implements IMemberService {
	private IMemberDao dao;		// DAO객체가 저장될 변수 선언
	private static MemberSerivceImpl service;	// 1
	
	// 생성자
	public MemberSerivceImpl() {	//2
//		dao = new MemberDaoImpl();	// DAO객체 생성
		dao = MemberDaoImpl.getInstance();	// 싱글톤 DAO객체 생성
	}
	
	// 3
	public static MemberSerivceImpl getInstance() {
		if(service==null) service = new MemberSerivceImpl();
		return service;
	}

	@Override
	public int insertMember(MemberVO memVO) {
		return dao.insertMember(memVO);
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String mem_id) {
		return dao.getMemberCount(mem_id);
	}


	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}
	
	
}
