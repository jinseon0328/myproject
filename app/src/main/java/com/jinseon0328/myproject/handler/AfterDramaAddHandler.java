package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class AfterDramaAddHandler extends AbstractDramaHandler {


  public AfterDramaAddHandler(List<Drama> dramaList) {
    super(dramaList);
  }
  @Override
  public void service() {

    System.out.println("[드라마 기록하기]");

    Drama d = new Drama();

    d.setWhen(Prompt.inputDate("언제: ")); 
    d.setWithWho(Prompt.inputString("누구와 함께: "));
    d.setWhere(Prompt.inputString("플랫폼: "));
    d.setTitle(Prompt.inputString("제목: "));
    d.setDirector(Prompt.inputString("연출: "));
    d.setCast(Prompt.inputString("등장인물: "));
    d.setWriter(Prompt.inputString("극본: "));
    d.setSynop(Prompt.inputString("줄거리: "));
    d.setMyRating(Prompt.inputString("별점: "));
    d.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));


    dramaList.add(d);

    System.out.println("본 영화를 등록하였습니다.");
  }
}
