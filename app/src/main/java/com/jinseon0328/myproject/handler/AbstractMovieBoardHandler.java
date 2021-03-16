package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Board;

public abstract class AbstractMovieBoardHandler {

  protected static List<Board> boardList;

  public AbstractMovieBoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  protected static Board findByNo(String boardName) {
    Board[] list = boardList.toArray(new Board[0]);
    for (Board b : list) {
      if (b.getName() == boardName) {
        return b;
      }
    }
    return null;
  }

}