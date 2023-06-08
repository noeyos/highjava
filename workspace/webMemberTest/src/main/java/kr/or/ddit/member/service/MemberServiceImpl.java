package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{

	private static IMemberService service;
	private IMemberDao dao;
	
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
	
	public static IMemberService getService() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.insertMember(vo);
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		return dao.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.updateMember(vo);
	}

	@Override
	public int checkId(String id) {
		// TODO Auto-generated method stub
		return dao.checkId(id);
	}

	@Override
	public MemberVO getMemberDetail(String id) {
		// TODO Auto-generated method stub
		return dao.getMemberDetail(id);
	}

}
