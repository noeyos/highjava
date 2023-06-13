package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;


public interface IMemberService {

	public int insertMember(MemberVO memVo);

	public int deleteMember(String memId);
	
	public int updateMember(MemberVO memVo);
	
	public List<MemberVO> getAllMember();
	
	public int getMemberCount(String memId);

	public MemberVO getMemberDetail(String memId);
	
}
