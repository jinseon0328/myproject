package com.jinseon0328.myproject.handler;

import java.util.ArrayList;
import java.util.List;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Prompt;

public class BeforeMovieSearchHandler extends AbstractMovieHandler {
  public BeforeMovieSearchHandler(List<Movie> movieList) {
    super(movieList);
  }
  public static void search() {
    String keyword = Prompt.inputString("검색할 영화를 입력해주세요: ");

    if (keyword.length() == 0) {
      System.out.println("검색할 영화를 입력하세요.");
      return;
    }
    ArrayList<Movie> list = new ArrayList<>();

    Movie[] movies = movieList.toArray(new Movie[movieList.size()]);
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

    for (Movie m : movies) {
      System.out.printf("<%s> %s with %s, %s점\n",
          m.getTitle(), 
          m.getWhen(), 
          m.getWithWho(),  
          m.getMyRating());
    }
  }
}
