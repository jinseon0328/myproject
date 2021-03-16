package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Movie;

public class AbstractMovieHandler {

  protected static List<Movie> movieList;

  public AbstractMovieHandler(List<Movie> movieList) {
    this.movieList = movieList;
  }

  public static Movie findByNo(String MovieTitle) {
    Movie[] list = movieList.toArray(new Movie[0]);
    for (Movie m : list) {
      if (m.getTitle().equals(MovieTitle)) {
        return m;
      }
    }
    return null;
  }

  public Movie findByName(String title) {
    Movie[] list = movieList.toArray(new Movie[0]);
    for (Movie m : list) {
      if (m.getTitle().equals(title)) {
        return m;
      }
    }
    return null;
  }
}
