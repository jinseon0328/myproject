package com.jinseon0328.myproject.handler;
import java.util.ArrayList;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Iterator;
import com.jinseon0328.util.List;
import com.jinseon0328.util.Prompt;

public class ToWatchMovieHandler {

  private List<Movie> movieList = new List<>();

  public void add() {

    System.out.println("[앞으로 볼 영화 기록]");

    Movie m = new Movie();

    m.setTitle(Prompt.inputString("제목: "));
    m.setWhen(Prompt.inputDate("언제: ")); 
    m.setWithWho(Prompt.inputString("누구와 함께: "));
    m.setMyRating(Prompt.inputString("별점: "));

    movieList.add(m);
  }


  public void list() throws CloneNotSupportedException {

    System.out.println("[영화 목록]");

    Iterator<Movie> iterator = (Iterator<Movie>) movieList.iterator();

    while (iterator.hasNext()) {
      Movie m = iterator.next();
      System.out.printf("<%s> %s with %s, 기대점:%s점\n",
          m.getTitle(), 
          m.getWhen(), 
          m.getWithWho(), 
          m.getMyRating());
    }
  }

  public void detail() {
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

  public void update() {
    System.out.println("[영화 변경]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", movie.getTitle());
    System.out.printf("언제: %s\n", movie.getWhen());
    System.out.printf("누구와 함께: %s\n", movie.getWithWho());
    System.out.printf("평점: %s\n", movie.getMyRating());

    java.sql.Date when = Prompt.inputDate(String.format("언제(->%s): ", movie.getWhen()));
    String withWho = Prompt.inputString(String.format("누구와 함께(->%s): ", movie.getWithWho()));
    String myRating = Prompt.inputString(String.format("평점(->%s): ", movie.getMyRating()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movie.setWhen(when);
      movie.setWithWho(withWho);
      movie.setWhere(myRating);
      System.out.println("영화를 변경하였습니다.");

    } else {
      System.out.println("영화 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[영화 삭제]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movieList.delete(movie);

      System.out.println("영화를 삭제하였습니다.");

    } else {
      System.out.println("영화 삭제를 취소하였습니다.");
    }
  }

  public void search() {
    String keyword = Prompt.inputString("검색할 영화를 입력해주세요: ");

    if (keyword.length() == 0) {
      System.out.println("검색할 영화를 입력하세요.");
      return;
    }
    ArrayList<Movie> list = new ArrayList<>();

    Movie[] Movies = movieList.toArray(new Movie[movieList.size()]);
    for (Movie m : movies) {
      if (m.getTitle().contains(keyword) ||
          m.getDirector().contains(keyword) ||
          m.getCast().contains(keyword)) {
        list.add(m);
      }
    }
    if (list.isEmpty()) {
      System.out.println("검색어에 해당하는 영화 기록이 없습니다.");
      return;
    }

    for (Movie m : movie) {
      System.out.printf("<%s> %s with %s, %s점\n",
          m.getTitle(), 
          m.getWhen(), 
          m.getWithWho(),  
          m.getMyRating());
    }
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

  private Movie findByNo(String MovieTitle) {
    Object[] list = movieList.toArray(new Movie[0]);
    for (Object obj : list) {
      Movie m = (Movie) obj;
      if (m.getTitle().equals(MovieTitle)) {
        return m;
      }
    }
    return null;
  }

  private Movie findByName(String title) {
    Object[] list = movieList.toArray(new Movie[0]);
    for (Object obj : list) {
      Movie m = (Movie) obj;
      if (m.getTitle().equals(title)) {
        return m;
      }
    }
    return null;
  }
}

