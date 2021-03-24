package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.util.Prompt;

public class DramaBoardDeleteHandler extends AbstractDramaBoardHandler{

  public DramaBoardDeleteHandler(List<Board> boardList) {
    super(boardList);
  }
  @Override
  public void service() {
    System.out.println("[추천 드라마 삭제]");

    String name = Prompt.inputString("제목? ");

    Board board = findByNo(name);
    if (board == null) {
      System.out.println("해당 영화의 추천글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      boardList.remove(board);

      System.out.println("게시글을 삭제하였습니다.");

    } else {
      System.out.println("게시글 삭제를 취소하였습니다.");
    }
  }
}
