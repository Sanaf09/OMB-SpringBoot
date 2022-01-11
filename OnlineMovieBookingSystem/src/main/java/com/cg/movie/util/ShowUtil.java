package com.cg.movie.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.movie.dto.ShowDetails;
import com.cg.movie.entities.Show;

@Component
public class ShowUtil {

	public ShowDetails toDetails(Show show) {
		return new ShowDetails(show.getShowId(),show.getShowName(),show.getShowDate(),show.getShowTime(),show.getMovieName(),show.getTheaterName(),show.getScreenName());
	}


	public List<ShowDetails> toDetails(Collection<Show> show) {
		List<ShowDetails> detailList = new ArrayList<>();
		for (Show show1 : show) {
			ShowDetails details = toDetails(show1);
			System.out.println(details);
			detailList.add(details);
			
		}
		return detailList;
	}

}
