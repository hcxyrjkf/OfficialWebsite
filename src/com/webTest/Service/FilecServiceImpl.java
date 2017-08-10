package com.webTest.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webTest.Bean.Filec;

import com.webTest.Dao.FilecDao;
@Service("filecService")
public class FilecServiceImpl implements FilecService{
	@Autowired
	private FilecDao filecDao;
	
	public FilecDao getFilecDao() {
		return filecDao;
	}

	public void setFilecDao(FilecDao filecDao) {
		this.filecDao = filecDao;
	}

	@Override
	public List<Filec> getFilecList() {
		 List<Filec> filecs= filecDao.getFilecList();
	        return filecs;
	}

	@Override
	public void add(Filec filec) {
		// TODO Auto-generated method stub
		filecDao.add(filec);
	}

	@Override
	public Filec get(int id) {
		// TODO Auto-generated method stub
		Filec filec = filecDao.get(id);
		return filec;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		filecDao.delete(id);
	}

	@Override
	public void update(Filec filec) {
		// TODO Auto-generated method stub
		filecDao.update(filec);
	}

}
