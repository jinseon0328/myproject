package com.jinseon0328.myproject.handler;
import java.sql.Date;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.util.List;
import com.jinseon0328.util.Prompt;

public class MovieBoardHandler {

  private List<Board> boardList = new List<>();
  private MovieBoardHandler movieBoardHandler;

  public MovieBoardHandler(AfterMovieHandler afterMovieHandler) {
    this.movieBoardHandler = movieBoardHandler;
  }

  public void movieAdd() {

    System.out.println("[추천 영화 등록]");

    Board b = new Board();

    b.setName(Prompt.inputString("제목: "));
    b.setReason(Prompt.inputString("추천 이유: "));
    b.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(b);

    System.out.println("게시글을 등록하였습니다.");
  }
  public void movieList() throws CloneNotSupportedException {

    System.out.println("[추천한 영화 목록]");
    Object[] list = boardList.toArray(new Board[0]);
    for (Object obj : list) {
      Board b = (Board) obj;
      System.out.printf("%s, %s, %s, %d, %d\n",  
          b.getName(), 
          b.getWriter(),
          b.getRegisteredDate(), 
          b.getViewCount(),
          b.getLike());
    }
  }
  public void movieDetail() {
    System.out.println("[추천한 영화 세부 사항]");
    String name = Prompt.inputString("제목: ");

    Board board = findByNo(name);
    if (board == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }
    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("제목: %s\n", board.getName());
    System.out.printf("추천 이유: %s\n", board.getReason());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("등록일: %s\n", board.getRegisteredDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
    System.out.printf("좋아요: %d\n", board.getLike());
  }


  public void movieUpdate() {
    System.out.println("[추천 영화 변경]");

    String name = Prompt.inputString("제목: ");

    Board board = findByNo(name);
    if (board == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }

    name = Prompt.inputString(String.format("제목(%s): ", board.getName()));
    String reason = Prompt.inputString(String.format("이유(%s): ", board.getReason()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      board.setName(name);
      board.setReason(reason);
      System.out.println("게시글을 변경하였습니다.");

    } else {
      System.out.println("게시글 변경을 취소하였습니다.");
    }
  }

  public void movieDelete() {
    System.out.println("[추천 영화 삭제]");

    String name = Prompt.inputString("제목? ");

    Board board = findByNo(name);
    if (board == null) {
      System.out.println("해당 영화의 추천글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      boardList.delete(board);

      System.out.println("게시글을 삭제하였습니다.");

    } else {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }
  }

  private Board findByNo(String boardName) {
    Object[] list = boardList.toArray(new Board[0]);
    for (Object obj : list) {
      Board b = (Board) obj;
      if (b.getName() == boardName) {
        return b;
      }
    }
    return null;
  }
}