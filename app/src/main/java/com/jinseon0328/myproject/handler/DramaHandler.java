package com.jinseon0328.myproject.handler;
import com.jinseon0328.myproject.handler.DramaList;
import java.util.Date;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class DramaHandler {

  public DramaList dramaList = new DramaList();

  public void add() {

    System.out.println("[드라마 기록하기]");

    Drama d = new Drama();

    d.when = Prompt.inputDate("언제: "); 
    d.withWho = Prompt.inputString("누구와 함께: ");
    d.where = Prompt.inputString("플랫폼: ");
    d.title = Prompt.inputString("제목: ");
    d.director = Prompt.inputString("연출: ");
    d.cast = Prompt.inputString("등장인물: ");
    d.writer = Prompt.inputString("극본: ");
    d.synop = Prompt.inputString("줄거리: ");
    d.myRating = Prompt.inputString("별점: ");
    d.registeredDate = new java.sql.Date(System.currentTimeMillis());


    dramaList.add(d);
  }


  public void list() {

    System.out.println("[드라마 목록보기]");

    Drama[] dramas = dramaList.toArray();
    for (Drama d : dramas) {
      System.out.printf("%s, %s, %s\n," + "%s, %s, %s, %s,\n"
          + "%s,\n" +"%s, %s\n", 
          d.when, d.withWho, d.where, 
          d.title, d.director, d.cast, d.writer, 
          d.synop, d.myRating, d.registeredDate );

    }
  }

  public void detail() {
    System.out.println("[드라마 기록 상세보기]");

    String title = Prompt.inputString("제목: ");

    Drama drama = dramaList.get(title);

    if (drama == null) {
      System.out.println("해당 제목의 드라마가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", drama.title);
    System.out.printf("언제: %s\n", drama.when);
    System.out.printf("누구와 함께: %s\n", drama.withWho);
    System.out.printf("플랫폼: %s\n", drama.where);
    System.out.printf("기록일: %s\n", drama.registeredDate);

  }

  public void update() {
    System.out.println("[드라마 변경]");

    String title = Prompt.inputString("제목: ");

    Drama drama = dramaList.get(title);
    if (drama == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", drama.title);
    System.out.printf("언제: %s\n", drama.when);
    System.out.printf("누구와 함께: %s\n", drama.withWho);
    System.out.printf("플랫폼: %s\n", drama.where);
    System.out.printf("기록일: %s\n", drama.registeredDate);

    String title1 = Prompt.inputString(String.format("제목(%s): ", drama.title));
    java.sql.Date when = Prompt.inputDate(String.format("언제(%s): ", drama.when));
    String withWho = Prompt.inputString(String.format("누구와 함께(%s): ", drama.withWho));
    String where = Prompt.inputString(String.format("플랫폼(%s): ", drama.where));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      drama.title = title1;
      drama.when = when;
      drama.withWho = withWho;
      drama.where = where;
      System.out.println("회원을 변경하였습니다.");

    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[드라마 삭제]");

    String title = Prompt.inputString("제목: ");

    Drama drama = dramaList.get(title);
    if (drama == null) {
      System.out.println("해당 드라마가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      dramaList.delete(title);

      System.out.println("드라마를 삭제하였습니다.");

    } else {
      System.out.println("드라마 삭제를 취소하였습니다.");
    }

  }
}





