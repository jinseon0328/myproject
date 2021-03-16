package com.jinseon0328.myproject.handler;

import java.util.Iterator;
import java.util.List;
import com.jinseon0328.myproject.domain.Board;

public class MovieBoardListHandler extends AbstractMovieBoardHandler {
  public MovieBoardListHandler(List<Board> boardList) {
    super(boardList);
  }

  public static void list() throws CloneNotSupportedException {
    System.out.println("[추천한 영화 목록]");

    Iterator<Board> iterator = boardList.iterator();

    while (iterator.hasNext()) {
      Board b = iterator.next();
      System.out.printf("%s, %s, %s, %d, %d\n",  
          b.getName(), 
          b.getWriter(),
          b.getRegisteredDate(), 
          b.getViewCount(),
          b.getLike());
    }
  }
}
