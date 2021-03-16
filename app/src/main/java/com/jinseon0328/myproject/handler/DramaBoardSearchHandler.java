package com.jinseon0328.myproject.handler;

import java.util.ArrayList;
import java.util.List;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.util.Prompt;

public class DramaBoardSearchHandler extends AbstractDramaBoardHandler {
  public DramaBoardSearchHandler(List<Board> boardList) {
    super(boardList);
  }
  public static void search() {
    String keyword = Prompt.inputString("드라마 게시글을 검색하세요. ");

    if (keyword.length() == 0) {
      System.out.println("검색어를 입력하세요.");
      return;
    }

    // 검색 결과를 담을 컬렉션을 준비한다.
    ArrayList<Board> list = new ArrayList<>();

    // 전체 게시글을 가져와서 검색어를 포함하는 게시글을 찾는다.
    Board[] boards = boardList.toArray(new Board[boardList.size()]);
    for (Board b : boards) {
      if (b.getName().contains(keyword) ||
          b.getWriter().contains(keyword)) {
        list.add(b);
      }
    }
    if (list.isEmpty()) {
      System.out.println("검색어에 해당하는 게시글이 없습니다.");
      return;
    }

    // 검색 결과를 출력한다.
    for (Board b : list) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          b.getName(), 
          b.getWriter(),
          b.getReason(),
          b.getRegisteredDate(), 
          b.getWriter(), 
          b.getViewCount(),
          b.getLike());
    }
  }
}
