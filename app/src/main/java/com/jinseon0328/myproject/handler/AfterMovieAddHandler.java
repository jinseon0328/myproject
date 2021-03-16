package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Prompt;

public class AfterMovieAddHandler extends AbstractMovieHandler {
  public AfterMovieAddHandler(List<Movie> movieList) {
    super(movieList);
  }
  public static void add() {

    System.out.println("[영화 기록]");

    Movie m = new Movie();

    m.setTitle(Prompt.inputString("제목: "));
    m.setWithWho(Prompt.inputString("누구와 함께: "));
    m.setWhen(Prompt.inputDate("언제: ")); 
    m.setMyRating(Prompt.inputString("별점: "));
    m.setWhere(Prompt.inputString("영화관: "));
    m.setDirector(Prompt.inputString("감독: "));
    m.setCast(Prompt.inputString("출연: "));
    m.setRunningTime(Prompt.inputString("상영시간: "));
    m.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));

    movieList.add(m);

    System.out.println("본 영화를 등록하였습니다.");
  }
}
