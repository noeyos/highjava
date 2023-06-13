package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;


public class MemberServiceImpl implements IMemberService {
	// 1번
	private static MemberServiceImpl service;
	
	private IMemberDao dao;		
	

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		
		return service;
	}

	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVO vo) {
		return dao.updateMember(vo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String id) {
		return dao.getMemberCount(id);
	}

	@Override
	public MemberVO getMemberDetail(String id) {
		return dao.getMemberDetail(id);
	}

}
