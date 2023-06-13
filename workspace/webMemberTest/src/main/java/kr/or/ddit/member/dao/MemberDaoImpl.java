package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisSqlSessionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl dao;
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO vo) {
		SqlSession session = null;
		int cnt = 0;  
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("member.insertMember", vo);
			
			if(cnt > 0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String id) {
		SqlSession session = null;
		int cnt = 0;  
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.delete("member.deleteMember", id);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		return cnt;
	}

	@Override
	public int updateMember(MemberVO vo) {
		SqlSession session = null;
		int cnt = 0;  
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.update("member.updateMember", vo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session = null;
		List<MemberVO> list = null;  
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			list = session.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return list;
	}

	@Override
	public int getMemberCount(String id) {
		SqlSession session = null;
		int count = 0;
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			count = session.selectOne("member.getMemberCount", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return count;
	}

	
	@Override
	public MemberVO getMemberDetail(String id) {
		SqlSession session = null;
		MemberVO vo = null;
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			vo = session.selectOne("member.getMemberDetail", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return vo;
	}

}
