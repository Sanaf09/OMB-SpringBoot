package com.cg.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.dto.ShowDetails;
import com.cg.movie.entities.Show;
import com.cg.movie.service.IShowService;
import com.cg.movie.util.ShowUtil;

@RestController
@RequestMapping
public class ShowController {
	@Autowired
	private  IShowService service;
	
	@Autowired
	private ShowUtil showUtil;
	
	
	@GetMapping("/findByShowName/{showName}")
	public List<ShowDetails> fetchByShowName(@PathVariable("showName") String showName, HttpServletRequest request){
		System.out.println("fetch name: " + showName);
		List<Show> show = service.findByName(showName);
		List<ShowDetails> res = showUtil.toDetails(show);
		System.out.println("by name details: " + res);
		return res;
		
	}
	
	@GetMapping("/displayAllShows")
	public List<ShowDetails> fetchAll(HttpServletRequest request) {
//		String userName = (String) request.getSession().getAttribute("user");
//		System.out.println(userName);
//		if(userName==null) {
//			throw new NotLoggedInException("You have not logged in");
//		}
		List<Show> show = service.findAll();
		List<ShowDetails> response = showUtil.toDetails(show);
		return response;
	}

	

}
