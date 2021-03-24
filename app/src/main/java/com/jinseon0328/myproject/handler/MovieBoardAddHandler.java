package com.jinseon0328.myproject.handler;

import java.sql.Date;
import java.util.List;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.util.Prompt;

public class MovieBoardAddHandler extends AbstractMovieBoardHandler{
  public MovieBoardAddHandler(List<Board> boardList) {
    super(boardList);
  }

  @Override
  public void service() {

    System.out.println("[추천 영화 등록]");

    Board b = new Board();

    b.setName(Prompt.inputString("제목: "));
    b.setReason(Prompt.inputString("추천 이유: "));
    b.setRegisteredDate(new Date(System.currentTimeMillis()));

    boardList.add(b);

    System.out.println("게시글을 등록하였습니다.");
  }
}
