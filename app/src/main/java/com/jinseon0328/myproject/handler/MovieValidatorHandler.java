package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Prompt;

public class MovieValidatorHandler extends AbstractMovieHandler {

  public MovieValidatorHandler(List<Movie> movieList) {
    super(movieList);
  }

  public String inputMovie(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } 
      if (findByName(name) != null) {
        return name;
      }
      System.out.println("등록된 영화가 아닙니다.");
    }
  }

  public String inputMovies(String promptTitle) {
    String movies = "";
    while (true) {
      String name = inputMovies(promptTitle);
      if (name == null) {
        return movies;
      } else {
        if (!movies.isEmpty()) {
          movies += ",";
        }
        movies += name;
      }
    }
  }
}
