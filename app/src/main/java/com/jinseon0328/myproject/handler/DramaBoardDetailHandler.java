package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.util.Prompt;

public class DramaBoardDetailHandler extends AbstractDramaBoardHandler{
  public DramaBoardDetailHandler(List<Board> boardList) {
    super(boardList);
  }
  public static void detail() {
    System.out.println("[추천한 드라마 세부 사항]");
    String name = Prompt.inputString("제목: ");

    Board board = findByNo(name);
    if (board == null) {
      System.out.println("해당 드라마가 없습니다.");
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

}
