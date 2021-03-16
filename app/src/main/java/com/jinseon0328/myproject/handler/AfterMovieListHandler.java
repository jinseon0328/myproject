package com.jinseon0328.myproject.handler;

import java.util.Iterator;
import java.util.List;
import com.jinseon0328.myproject.domain.Movie;

public class AfterMovieListHandler extends AbstractMovieHandler {
  public AfterMovieListHandler(List<Movie> movieList) {
    super(movieList);
  }
  public static void list() throws CloneNotSupportedException {

    System.out.println("[영화 목록]");

    Iterator<Movie> iterator = movieList.iterator();

    while (iterator.hasNext()) {
      Movie m = iterator.next();

      System.out.printf("<%s> %s with %s, %s점\n",
          m.getTitle(), 
          m.getWhen(), 
          m.getWithWho(),  
          m.getMyRating());
    }
  }
}
