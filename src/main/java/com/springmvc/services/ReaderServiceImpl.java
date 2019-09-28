package com.springmvc.services;

import java.util.List;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.springmvc.models.Reader;

@Service
public class ReaderServiceImpl implements ServiceBase<Reader> {

	@Override
	@Transactional
	public List<Reader> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Reader getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean save(Reader entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean update(Reader entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean delete(Reader entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
