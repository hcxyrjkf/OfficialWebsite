package com.webTest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.webTest.Bean.Filec;


public interface FilecDao {
	public List<Filec> getFilecList();
	public void add(Filec filec);
    public Filec get(int id);
    public void delete(int id);
    public void update(Filec filec);
}
