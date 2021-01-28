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

  public void detail() {
    System.out.println("[추천한 영화 세부 사항]");

    String name = Prompt.inputString("제목: ");

    Board board = findByName(name);
    if (board == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }
    board.viewCount++;
    System.out.printf("제목: %s\n", board.name);
    System.out.printf("추천 이유: %s\n", board.reason);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("좋아요: %d\n", board.like);
  }

  public void update() {
    System.out.println("[추천 영화 변경]");

    String name = Prompt.inputString("제목: ");

    Board board = findByName(name);
    if (board == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }

    name = Prompt.inputString(String.format("제목(%s): ", board.name));
    String reason = Prompt.inputString(String.format("이유(%s): ", board.reason));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      board.name = name;
      board.reason = reason;
      System.out.println("게시글을 변경하였습니다.");

    } else {
      System.out.println("게시글 변경을 취소하였습니다.");
    }
  }
  // 영화 이름에 해당하는 인스턴스를 배열에서 찾아 그 인덱스를 리턴한다. 
  int indexOf(String boardName) {
    for (int i = 0; i < this.size; i++) {
      Board board = this.boards[i];
      if (board.name == boardName) {
        return i;
      }
    }
    return -1;
  }

  // 영화 이름에 해당하는 인스턴스를 찾아 리턴한다.
  Board findByName(String boardName) {
    int i = indexOf(boardName);
    if (i == -1) 
      return null;
    else 
      return this.boards[i];
  }
}

