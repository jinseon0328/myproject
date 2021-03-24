package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Prompt;

public class BeforeMovieDeleteHandler extends AbstractMovieHandler {
  public BeforeMovieDeleteHandler(List<Movie> movieList) {
    super(movieList);
  }
  @Override
  public void service() {
    System.out.println("[영화 삭제]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movieList.remove(movie);

      System.out.println("영화를 삭제하였습니다.");

    } else {
      System.out.println("영화 삭제를 취소하였습니다.");
    }
  }
}
