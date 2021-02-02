package com.jinseon0328.myproject.handler;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Prompt;

public class MovieHandler {

  public MovieList movieList = new MovieList();

  public void add() {

    System.out.println("[영화 기록하기]");

    Movie m = new Movie();

    m.when = Prompt.inputDate("언제: "); 
    m.withWho = Prompt.inputString("누구와 함께: ");
    m.where = Prompt.inputString("영화관: ");
    m.title = Prompt.inputString("제목: ");
    m.director = Prompt.inputString("감독: ");
    m.cast = Prompt.inputString("출연: ");
    m.runningTime = Prompt.inputString("상영시간: ");
    m.releaseDate = Prompt.inputDate("개봉일: ");
    m.synop = Prompt.inputString("줄거리: ");
    m.myRating = Prompt.inputString("별점: ");
    m.registeredDate = new java.sql.Date(System.currentTimeMillis());

    movieList.add(m);
  }


  public void list() {
    System.out.println("[영화 목록보기]");
    Movie[] movies = movieList.toArray();
    for (Movie m : movies) {
      System.out.printf("%s, %s, %s,\n"
          + "%s, %s, %s,\n" + "%s, %s,\n" +"%s,\n" + "%s, %s\n",
          m.when, m.withWho, m.where,
          m.title, m.director, m.cast, m.runningTime, m.releaseDate, 
          m.synop, m.myRating, m.registeredDate);
    }
  }

  public void detail() {
    System.out.println("[영화 기록 상세보기]");

    String title = Prompt.inputString("제목: ");

    Movie movie = movieList.get(title);

    if (movie == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", movie.title);
    System.out.printf("언제: %s\n", movie.when);
    System.out.printf("누구와 함께: %s\n", movie.withWho);
    System.out.printf("영화관: %s\n", movie.where);
    System.out.printf("기록일: %s\n", movie.registeredDate);

  }

  public void update() {
    System.out.println("[영화 변경]");

    String title = Prompt.inputString("제목: ");

    Movie drama = movieList.get(title);
    if (drama == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", drama.title);
    System.out.printf("언제: %s\n", drama.when);
    System.out.printf("누구와 함께: %s\n", drama.withWho);
    System.out.printf("영화관: %s\n", drama.where);
    System.out.printf("기록일: %s\n", drama.registeredDate);

    String title1 = Prompt.inputString(String.format("제목(%s): ", drama.title));
    java.sql.Date when = Prompt.inputDate(String.format("언제(%s): ", drama.when));
    String withWho = Prompt.inputString(String.format("누구와 함께(%s): ", drama.withWho));
    String where = Prompt.inputString(String.format("플랫폼(%s): ", drama.where));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      drama.title = title1;
      drama.when = when;
      drama.withWho = withWho;
      drama.where = where;
      System.out.println("영화를 변경하였습니다.");

    } else {
      System.out.println("영화 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[영화 삭제]");

    String title = Prompt.inputString("제목: ");

    Movie drama = movieList.get(title);
    if (drama == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movieList.delete(title);

      System.out.println("영화를 삭제하였습니다.");

    } else {
      System.out.println("영화 삭제를 취소하였습니다.");
    }

  }
}





