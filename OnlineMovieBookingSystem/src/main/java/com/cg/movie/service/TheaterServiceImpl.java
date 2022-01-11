package com.cg.movie.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.IMovieDao;
import com.cg.movie.dao.IScreenDao;
import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;
import com.cg.movie.exception.ScreenNotFoundException;
@Service
@Transactional
public class TheaterServiceImpl implements ITheaterService{
	@Autowired
	private IMovieDao mDao;
	
	@Autowired
	private IScreenDao sDao;
	
	@Override
	public List<Movies> findByName(String movieName) {
		System.out.println("moviename: " + movieName);
		List<Movies> list = mDao.findByName(movieName);
		return list;		
	}

	@Override
	public Screens findById(Integer screenId) {
		System.out.println("id: "+ screenId);
        Optional<Screens> optional = sDao.findById(screenId);
        if(!optional.isPresent()){
        	System.out.println("***error***");
            throw new ScreenNotFoundException("screen not found for id="+screenId);
        }
        Screens screen=optional.get();
        System.out.println("stud: "+ screen);
        return screen;
	}

}
