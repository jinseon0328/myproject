package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Board;

public abstract class AbstractDramaBoardHandler {

  protected static List<Board> boardList;

  public AbstractDramaBoardHandler(List<Board> boardList) {
    this.boardList = boardList;
  }

  protected static Board findByNo(String boardName) {
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
