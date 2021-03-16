package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Prompt;

public class AfterMovieUpdateHandler extends AbstractMovieHandler {
  public AfterMovieUpdateHandler(List<Movie> movieList) {
    super(movieList);
  }
  public static void update() {
    System.out.println("[영화 변경]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("언제: %s\n", movie.getWhen());
    System.out.printf("누구와 함께: %s\n", movie.getWithWho());
    System.out.printf("평점: %s\n", movie.getMyRating());


    java.sql.Date when = Prompt.inputDate(String.format("언제: %s -> ", movie.getWhen()));
    String withWho = Prompt.inputString(String.format("누구와 함께: %s -> ", movie.getWithWho()));
    String myRating = Prompt.inputString(String.format("평점: %s -> ", movie.getMyRating()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movie.setTitle(title);
      movie.setWhen(when);
      movie.setWithWho(withWho);
      movie.setWhere(myRating);
      System.out.println("영화를 변경하였습니다.");

    } else {
      System.out.println("영화 변경을 취소하였습니다.");
    }
  }

}
