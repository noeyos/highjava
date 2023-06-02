package kr.or.ddit.basic.fileUpload.service;

import java.util.List;

import kr.or.ddit.basic.fileUpload.dao.FileInfoDaoImpl;
import kr.or.ddit.basic.fileUpload.dao.IFileInfoDao;
import kr.or.ddit.vo.FileInfoVO;

public class FileInfoServiceImpl implements IFileInfoService {
	
	private static FileInfoServiceImpl service;
	private IFileInfoDao dao;
	
	private FileInfoServiceImpl() {
		dao = FileInfoDaoImpl.getInstance();
	}
	
	public static FileInfoServiceImpl getInstance() {
		if(service==null) service = new FileInfoServiceImpl();
		return service;
	}

	@Override
	public int insertFileInfo(FileInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.insertFileInfo(vo);
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		// TODO Auto-generated method stub
		return dao.getAllFileInfo();
	}

	@Override
	public FileInfoVO getFilInfo(int fileNo) {
		// TODO Auto-generated method stub
		return dao.getFilInfo(fileNo);
	}

	

}
