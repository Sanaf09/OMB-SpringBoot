package com.cg.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.movie.dao.IShowDao;
import com.cg.movie.entities.Show;

@Service
@Transactional
public class ShowServiceImpl implements IShowService {
	@Autowired
	private IShowDao sDao;

	@Override
	public List<Show> findByName(String showName) {
		System.out.println("name: " + showName);
		List<Show> list = sDao.findByName(showName);
		return list;
	}

	@Override
	public List<Show> findAll() {
		System.out.println(sDao.getClass().getName());
		List<Show> list = sDao.findAll();
		return list;
	}

	
}
