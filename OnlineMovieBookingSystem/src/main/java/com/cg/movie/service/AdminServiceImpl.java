package com.cg.movie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.movie.dao.IAdminMovieDao;
import com.cg.movie.dao.IAdminScreenDao;
import com.cg.movie.dao.IAdminShowDao;
import com.cg.movie.dao.IAdminTheaterDao;
import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;
import com.cg.movie.entities.Show;
import com.cg.movie.entities.Theater;
import com.cg.movie.exception.MovieAlreadyExistsException;
import com.cg.movie.exception.MovieNotFoundException;
import com.cg.movie.exception.ScreenAlreadyExistsException;
import com.cg.movie.exception.ScreenNotFoundException;
import com.cg.movie.exception.ShowAlreadyExistsException;
import com.cg.movie.exception.ShowNotFoundException;
import com.cg.movie.exception.TheaterAlreadyExistsException;
import com.cg.movie.exception.TheaterNotFoundException;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminTheaterDao aDao;
	@Autowired
	private IAdminMovieDao mDao;
	@Autowired
	private IAdminScreenDao sDao;
	@Autowired
	private IAdminShowDao showDao;
	
	@Override
	public Theater addTheater(Theater theater) {
		boolean exists = theater.getTheaterId() != null && aDao.existsById(theater.getTheaterId());
		if (exists) {
			throw new TheaterAlreadyExistsException("Theater already exists for id=" + theater.getTheaterId());
		}
		theater = aDao.save(theater);
		System.out.println("returning saved theater: " + theater);
		return theater;

	}

	@Override
	public Theater deleteTheater(Integer theaterId) {
		Optional<Theater> op = aDao.findById(theaterId);
		Theater theater = null;
		if (op.isPresent()) {
			theater = op.get();
			aDao.delete(theater);
		}

		return theater;

	}

	@Override
	public Movies addMovie(Movies movies) {
		boolean exists = movies.getMovieId() != null && aDao.existsById(movies.getMovieId());
		if (exists) {
			throw new MovieAlreadyExistsException("Movie already exists for id=" + movies.getMovieId());
		}
		movies = mDao.save(movies);
		System.out.println("returning saved movie: " + movies);
		return movies;

	}

	@Override
	public Movies deleteMovie(Integer movieId) {
		Optional<Movies> op = mDao.findById(movieId);
		Movies movies = null;
		if (op.isPresent()) {
			movies = op.get();
			mDao.delete(movies);
		}

		return movies;

	}

	@Override
	public Screens addScreen(Screens screen) {
		boolean exists = screen.getScreenId() != null && aDao.existsById(screen.getScreenId());
		if (exists) {
			throw new ScreenAlreadyExistsException("Screen already exists for id=" + screen.getScreenId());
		}
		screen = sDao.save(screen);
		System.out.println("returning saved screen: " + screen);
		return screen;
	}

	@Override
	public Screens deleteScreen(Integer screenId) {
		Optional<Screens> op = sDao.findById(screenId);
		Screens screens = null;
		if (op.isPresent()) {
			screens = op.get();
			sDao.delete(screens);
		}

		return screens;
	}

	@Override
	public Show addShow(Show show) {
		boolean exists = show.getShowId() != null && aDao.existsById(show.getShowId());
		if (exists) {
			throw new ShowAlreadyExistsException("Movie already exists for id=" + show.getShowId());
		}
		show = showDao.save(show);
		System.out.println("returning saved show: " + show);
		return show;
	}

	@Override
	public Show deleteShow(Integer showId) {
		Optional<Show> op = showDao.findById(showId);
		Show show = null;
		if (op.isPresent()) {
			show = op.get();
			showDao.delete(show);
		}

		return show;
	}
//////////////////////////////////////////////////////////////////////
	public Theater findById(Integer id) {
		System.out.println("id: "+id);
        Optional<Theater> optional = aDao.findById(id);
        if(!optional.isPresent()){
        	System.out.println("***error***");
            throw new TheaterNotFoundException("Theater not found for id="+id);
        }
        Theater theater=optional.get();
        System.out.println("Theater: "+ theater);
        return theater;
	}
	
	public Movies findById1(Integer id) {
		System.out.println("id: "+id);
        Optional<Movies> optional = mDao.findById(id);
        if(!optional.isPresent()){
        	System.out.println("***error***");
            throw new MovieNotFoundException("Movie not found for id="+id);
        }
        Movies movie=optional.get();
        System.out.println("Movie: "+ movie);
        return movie;
	}
	
	public Screens findById2(Integer id) {
		System.out.println("id: "+id);
        Optional<Screens> optional = sDao.findById(id);
        if(!optional.isPresent()){
        	System.out.println("***error***");
            throw new ScreenNotFoundException("Movie not found for id="+id);
        }
        Screens screen=optional.get();
        System.out.println("Screens: "+ screen);
        return screen;
	}
	
	public Show findById3(Integer id) {
		System.out.println("id: "+id);
        Optional<Show> optional = showDao.findById(id);
        if(!optional.isPresent()){
        	System.out.println("***error***");
            throw new ShowNotFoundException("Show not found for id="+id);
        }
        Show show=optional.get();
        System.out.println("Show: "+ show);
        return show;
	}

}
