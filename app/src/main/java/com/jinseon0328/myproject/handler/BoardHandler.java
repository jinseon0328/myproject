package com.jinseon0328.myproject.handler;
import java.sql.Date;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.util.Prompt;

public class BoardHandler {

  static final int LENGTH = 100;
  Board[] boards = new Board[LENGTH];   
  int size = 0;

  public void add(MovieHandler movieList) {

    System.out.println("[추천 영화 등록]");

    Board b = new Board();

    while (true) {
      String cinema = Prompt.inputString("제목: ");
      if (movieList.exist(cinema)) {
        b.name = cinema;
        break;
      }
      System.out.println("감상한 영화가 아닙니다.");
    }

    b.reason = Prompt.inputString("추천 이유: ");
    b.writer = Prompt.inputString("글쓴이: ");
    b.registeredDate = new Date(System.currentTimeMillis());

    boards[this.size++] = b;

    System.out.println("추천 영화를 등록하였습니다.");
  }

  public void list() {
    System.out.println("[추천한 영화 목록]");

    for (int i = 0; i < this.size; i++) {
      Board b = this.boards[i];
      // 번호, 제목, 등록일, 작성자, 조회수, 좋아요
      System.out.printf("%s, %s, %s, %d, %d\n",  
          b.name, 
          b.writer,
          b.registeredDate, 
          b.viewCount,
          b.like);
    }
  }
}