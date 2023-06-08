package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.MyBatisSqlSessionFactory;

public class MemberDaoImpl implements IMemberDao{

	private static IMemberDao dao;
	
	public static IMemberDao getDao() {
		if (dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		SqlSession sqlSession = null;
		List<MemberVO> list = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			list = sqlSession.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}

	@Override
	public int insertMember(MemberVO vo) {
		SqlSession sqlSession = null;
		int res = 0;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			res = sqlSession.insert("member.insertMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return res;
	}

	@Override
	public int deleteMember(String id) {
		SqlSession sqlSession = null;
		int res = 0;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			res = sqlSession.delete("member.deleteMember", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return res;
	}

	@Override
	public int updateMember(MemberVO vo) {
		SqlSession sqlSession = null;
		int res = 0;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			res = sqlSession.update("member.updateMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return res;
	}

	@Override
	public int checkId(String id) {
		SqlSession sqlSession = null;
		int res = 0;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			res = sqlSession.selectOne("member.checkId", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return res;
	}

	@Override
	public MemberVO getMemberDetail(String id) {
		SqlSession sqlSession = null;
		MemberVO vo = null;
		try {
			sqlSession = MyBatisSqlSessionFactory.getSqlSession();
			vo = sqlSession.selectOne("member.getMemberDetail", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return vo;
	}
	

}
