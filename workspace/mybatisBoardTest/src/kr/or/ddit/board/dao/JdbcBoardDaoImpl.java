package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.util.DBUtil3;
import kr.or.ddit.board.vo.JdbcBoardVO;
import kr.or.ddit.util.MyBatisSqlSessionFactory;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	private static JdbcBoardDaoImpl dao;
	
	private JdbcBoardDaoImpl() {}
	
	public static JdbcBoardDaoImpl getInstance() {
		if(dao==null) dao = new JdbcBoardDaoImpl();
		return dao;
	}

	@Override
	public int insertBoard(JdbcBoardVO boardVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
					
			cnt = session.insert("board.insertBoard", boardVo);
			if(cnt>0) session.commit();
			
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
					
			cnt = session.insert("board.deleteBoard", boardNo);
			if(cnt>0) session.commit();
			
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO boardVo) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
					
			cnt = session.insert("board.updateBoard", boardVo);
			if(cnt>0) session.commit();
			
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		SqlSession session = null;
		JdbcBoardVO boardVo = null;

		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
					
			boardVo = session.selectOne("board.getBoard", boardNo);
			// ==> 레코드가 하나밖에 안 나올 땐 selectOne 사용
			
		} finally {
			if(session!=null) session.close();
		}
		
		return boardVo;
	}

	@Override
	public List<JdbcBoardVO> getAllBoard() {
		SqlSession session = null;
		List<JdbcBoardVO> boardList = null;
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
					
			boardList = session.selectList("board.getAllBoard");
			// ==> List같이 레코드가 여러개일 경우 selectList 사용
			
		} finally {
			if(session!=null) session.close();
		}
		
		return boardList;
	}

	@Override
	public List<JdbcBoardVO> getSearchBoard(String title) {
		SqlSession session = null;
		List<JdbcBoardVO> boardList = null;

		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
					
			boardList = session.selectList("board.getSearchBoard", title);
			// ==> List같이 레코드가 여러개일 경우 selectList 사용
			
		} finally {
			if(session!=null) session.close();
		}
		
		return boardList;
	}

	@Override
	public int setCountIncrement(int boardNo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
					
			cnt = session.insert("board.setCountIncrement", boardNo);
			if(cnt>0) session.commit();
			
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}
	
	

}
