package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Prompt;

public class BeforeMovieAddHandler extends AbstractMovieHandler {
  public BeforeMovieAddHandler(List<Movie> movieList) {
    super(movieList);
  }
  public static void add() {

    System.out.println("[앞으로 볼 영화 기록]");

    Movie m = new Movie();

    m.setTitle(Prompt.inputString("제목: "));
    m.setWhen(Prompt.inputDate("언제: ")); 
    m.setWithWho(Prompt.inputString("누구와 함께: "));
    m.setMyRating(Prompt.inputString("별점: "));

    movieList.add(m);
  }
}
