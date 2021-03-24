package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Movie;

public abstract class AbstractMovieHandler implements Command {

  protected List<Movie> movieList;

  public AbstractMovieHandler(List<Movie> movieList) {
    this.movieList = movieList;
  }

  protected Movie findByNo(String MovieTitle) {
    Movie[] list = movieList.toArray(new Movie[0]);
    for (Movie m : list) {
      if (m.getTitle().equals(MovieTitle)) {
        return m;
      }
    }
    return null;
  }

  protected Movie findByName(String title) {
    Movie[] list = movieList.toArray(new Movie[0]);
    for (Movie m : list) {
      if (m.getTitle().equals(title)) {
        return m;
      }
    }
    return null;
  }
}
