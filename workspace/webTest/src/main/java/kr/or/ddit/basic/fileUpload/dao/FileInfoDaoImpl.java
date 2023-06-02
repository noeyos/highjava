package kr.or.ddit.basic.fileUpload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisSqlSessionFactory;
import kr.or.ddit.vo.FileInfoVO;

public class FileInfoDaoImpl implements IFileInfoDao{
	
	private static FileInfoDaoImpl dao;
	
	private FileInfoDaoImpl() {}
	
	public static FileInfoDaoImpl getInstance() {
		if(dao==null) dao = new FileInfoDaoImpl();
		return dao;
	}

	@Override
	public int insertFileInfo(FileInfoVO fivo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			cnt = session.insert("fileinfo.insertFileInfo", fivo);
			
			if(cnt>0) session.commit();
			
		} finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		List<FileInfoVO> fileList = null;
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			fileList = session.selectList("fileinfo.getAllFileInfo");
		} finally {
			if(session!=null) session.close();
		}
		return fileList;
	}

	@Override
	public FileInfoVO getFilInfo(int fileNo) {
		FileInfoVO vo = null;
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.getSqlSession();
			vo = session.selectOne("fileinfo.getFileInfo", fileNo);
		} finally {
			if(session!=null) session.close();
		}
		return vo;
	}



}
