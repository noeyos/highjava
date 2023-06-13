package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;


public interface IMemberDao {

	public int insertMember(MemberVO memVo);
	
	public int deleteMember(String memId);
	
	public int updateMember(MemberVO memVo);

	public List<MemberVO> getAllMember();

	public int getMemberCount(String memId);

	public MemberVO getMemberDetail(String memId);
	
}













