package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class AfterDramaUpdateHandler extends AbstractDramaHandler{
  public AfterDramaUpdateHandler(List<Drama> dramaList) {
    super(dramaList);
  } 

  public static void update() {
    System.out.println("[드라마 변경]");

    String title = Prompt.inputString("제목: ");

    Drama drama = findByNo(title);
    if (drama == null) {
      System.out.println("해당 드라마가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", drama.getTitle());
    System.out.printf("언제: %s\n", drama.getWhen());
    System.out.printf("누구와 함께: %s\n", drama.getWithWho());
    System.out.printf("플랫폼: %s\n", drama.getWhere());
    System.out.printf("기록일: %s\n", drama.getRegisteredDate());

    String title1 = Prompt.inputString(String.format("제목(%s): ", drama.getTitle()));
    java.sql.Date when = Prompt.inputDate(String.format("언제(%s): ", drama.getWhen()));
    String withWho = Prompt.inputString(String.format("누구와 함께(%s): ", drama.getWithWho()));
    String where = Prompt.inputString(String.format("플랫폼(%s): ", drama.getWhere()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      drama.setTitle(title1);
      drama.setWhen(when);
      drama.setWithWho(withWho);
      drama.setWhere(where);
      System.out.println("드라마를 변경하였습니다.");

    } else {
      System.out.println("드라마 변경을 취소하였습니다.");
    }
  }
}
