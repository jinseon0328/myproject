package com.jinseon0328.myproject.handler;

import java.util.ArrayList;
import java.util.List;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class AfterDramaSearchHandler extends AbstractDramaHandler {

  public AfterDramaSearchHandler(List<Drama> dramaList) {
    super(dramaList);
  }


  public static void search() {
    String keyword = Prompt.inputString("검색할 드라마를 입력해주세요: ");

    if (keyword.length() == 0) {
      System.out.println("검색할 드라마를 입력하세요.");
      return;
    }
    ArrayList<Drama> list = new ArrayList<>();

    Drama[] dramas = dramaList.toArray(new Drama[dramaList.size()]);
    for (Drama d : dramas) {
      if (d.getTitle().contains(keyword) ||
          d.getDirector().contains(keyword) ||
          d.getCast().contains(keyword)) {
        list.add(d);
      }
    }
    if (list.isEmpty()) {
      System.out.println("검색어에 해당하는 드라마 기록이 없습니다.");
      return;
    }

    for (Drama m : dramas) {
      System.out.printf("<%s> %s with %s, %s점\n",
          m.getTitle(), 
          m.getWhen(), 
          m.getWithWho(),  
          m.getMyRating());
    }
  }

}
