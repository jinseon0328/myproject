package com.jinseon0328.myproject.handler;
import java.sql.Date;
import com.jinseon0328.util.Prompt;

public class MovieHandler {

  static class Movie {

    String title;
    String director;
    String cast;
    String runningTime;
    Date releaseDate;
    String synop;
    String myRating;
    Date registeredDate;

  }

  static final int NUMBER = 100;
  static Movie[] movies = new Movie[NUMBER]; 
  static int size = 0;

  public static void add() {

    System.out.println("[감상한 영화 기록하기]");

    Movie m = new Movie();

    m.title = Prompt.inputString("제목: ");
    m.director = Prompt.inputString("감독: ");
    m.cast = Prompt.inputString("출연: ");
    m.runningTime = Prompt.inputString("상영시간: ");
    m.releaseDate = Prompt.inputDate("개봉일: ");
    m.synop = Prompt.inputString("줄거리: ");
    m.myRating = Prompt.inputString("별점: ");
    m.registeredDate = new java.sql.Date(System.currentTimeMillis());
    movies[size++] = m;
  }


  public static void list() {
    System.out.println("[감상한 영화 목록보기]");
    for (int i = 0; i < size; i++) {
      Movie m =  movies[i];
      System.out.printf("%s, %s, %s, %s, %s, %s, %s, %s\n",
          m.title, m.director, m.cast, m.runningTime, m.releaseDate, 
          m.synop, m.myRating, m.registeredDate);

    }

  }

}

