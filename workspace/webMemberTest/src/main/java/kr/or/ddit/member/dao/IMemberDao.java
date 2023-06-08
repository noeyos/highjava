package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberDao {
	
	public List<MemberVO> getAllMember();
	
	public int insertMember(MemberVO vo);
	
	public int deleteMember(String id);
	
	public int updateMember(MemberVO vo);
	
	public int checkId(String id);
	
	public MemberVO getMemberDetail(String id);
}