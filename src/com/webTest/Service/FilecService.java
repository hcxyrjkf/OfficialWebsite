package com.webTest.Service;

import java.util.List;

import com.webTest.Bean.Filec;

public interface FilecService {
	public List<Filec> getFilecList();
	public void add(Filec filec);
    public Filec get(int id);
    public void delete(int id);
    public void update(Filec file);
}
