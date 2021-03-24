package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class BeforeDramaDeleteHandler extends AbstractDramaHandler {
  public BeforeDramaDeleteHandler(List<Drama> dramaList) {
    super(dramaList);
  }

  @Override
  public void service() {
    System.out.println("[드라마 삭제]");

    String title = Prompt.inputString("제목: ");

    Drama drama = findByNo(title);
    if (drama == null) {
      System.out.println("해당 드라마가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      dramaList.remove(drama);

      System.out.println("드라마를 삭제하였습니다.");

    } else {
      System.out.println("드라마 삭제를 취소하였습니다.");
    }
  }


}
