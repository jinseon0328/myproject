package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Prompt;

public class AfterMovieDetailHandler extends AbstractMovieHandler {
  public AfterMovieDetailHandler(List<Movie> movieList) {
    super(movieList);
  }
  public static void detail() {
    System.out.println("[영화 상세 기록]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);

    if (movie == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", movie.getTitle());
    System.out.printf("영화관: %s\n", movie.getWhere());
    System.out.printf("감독: %s\n", movie.getDirector());
    System.out.printf("출연: %s\n", movie.getCast());
    System.out.printf("상영시간: %s\n", movie.getRunningTime());
    System.out.printf("개봉일: %s\n", movie.getReleaseDate());
    System.out.printf("내용: %s\n", movie.getSynop());
    System.out.printf("기록일: %s\n", movie.getRegisteredDate());

  }

}
