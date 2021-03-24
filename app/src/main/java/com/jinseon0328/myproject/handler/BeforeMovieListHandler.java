package com.jinseon0328.myproject.handler;

import java.util.Iterator;
import java.util.List;
import com.jinseon0328.myproject.domain.Movie;

public class BeforeMovieListHandler extends AbstractMovieHandler {
  public BeforeMovieListHandler(List<Movie> movieList) {
    super(movieList);
  }
  @Override
  public void service() {

    System.out.println("[영화 목록]");

    Iterator<Movie> iterator = movieList.iterator();

    while (iterator.hasNext()) {
      Movie m = iterator.next();
      System.out.printf("<%s> %s with %s, 기대점:%s점\n",
          m.getTitle(), 
          m.getWhen(), 
          m.getWithWho(), 
          m.getMyRating());
    }
  }
}
