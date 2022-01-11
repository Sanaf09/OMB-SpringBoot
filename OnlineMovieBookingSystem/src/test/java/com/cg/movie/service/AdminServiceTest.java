package com.cg.movie.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;
import com.cg.movie.entities.Show;
import com.cg.movie.entities.Theater;

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(AdminServiceImpl.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AdminServiceTest {
	// this class will be used to test business logic of student service.

	@Autowired
	private AdminServiceImpl service;
	
	@Test
	public void testAddTheater() {
		Theater theater = service.addTheater(new Theater("PVR","MUMBAI","SHASHANK","9920765239"));
		Integer id = theater.getTheaterId();
		Theater theaterFound = service.findById(id);
		System.out.println(theaterFound);
		Assertions.assertEquals(theaterFound.getTheaterName(), theater.getTheaterName());
	}
	
	@Test
	public void testAddMovie() {
		Movies movie = service.addMovie(new Movies("SPIDER MAN","TOBY SMITH",2,null,"ENGLISH","ACTION"));
		Integer id = movie.getMovieId();
		Movies movieFound = service.findById1(id);
		System.out.println(movieFound);
		Assertions.assertEquals(movieFound.getMovieName(), movie.getMovieName());
	}
	
	@Test
	public void testAddScreen() {
		Screens screen = service.addScreen(new Screens("Silver Screen",null,12));
		Integer id = screen.getScreenId();
		Screens screenFound = service.findById2(id);
		System.out.println(screenFound);
		Assertions.assertEquals(screenFound.getScreenName(), screen.getScreenName());
	}
	
	@Test
	public void testAddShow() {
		Show show = service.addShow(new Show("Evening Show",null,"03:30 PM","SPIDER MAN","PVR","Silver Screen"));
		Integer id = show.getShowId();
		Show showFound = service.findById3(id);
		System.out.println(showFound);
		Assertions.assertEquals(showFound.getShowName(), show.getShowName());
	}
	
	
}
