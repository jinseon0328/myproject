package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.util.Prompt;

public class DramaBoardUpdateHandler extends AbstractDramaBoardHandler {
  public DramaBoardUpdateHandler(List<Board> boardList) {
    super(boardList);
  }
  public static void update() {
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
}
