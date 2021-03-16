package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class BeforeDramaDetailHandler extends AbstractDramaHandler {
  public BeforeDramaDetailHandler(List<Drama> dramaList) {
    super(dramaList);
  }

  public static void detail() {
    System.out.println("[드라마 기록 상세보기]");

    String title = Prompt.inputString("제목: ");

    Drama drama = findByNo(title);

    if (drama == null) {
      System.out.println("해당 제목의 드라마가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", drama.getTitle());
    System.out.printf("언제: %s\n", drama.getWhen());
    System.out.printf("누구와 함께: %s\n", drama.getWithWho());
    System.out.printf("플랫폼: %s\n", drama.getWhere());
    System.out.printf("기록일: %s\n", drama.getRegisteredDate());

  }


}
