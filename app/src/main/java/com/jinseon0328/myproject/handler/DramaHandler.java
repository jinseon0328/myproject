package com.jinseon0328.myproject.handler;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.List;
import com.jinseon0328.util.Prompt;

public class DramaHandler {

  public void service() {
    loop:
      while (true) {
        System.out.println("My Drama: ");
        System.out.println("\t나의 드라마기록 보관함\n");
        System.out.println("1. 드라마 기록하기");
        System.out.println("2. 드라마 목록보기");
        System.out.println("3. 드라마 상세보기");
        System.out.println("4. 기록한 드라마 변경하기");
        System.out.println("5. 기록한 드라마 삭제하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        switch (command) {
          case "1":
            this.add();
            break;
          case "2":
            this.list();
            break;
          case "3":
            this.detail();
            break;
          case "4":
            this.update();
            break;
          case "5":
            this.delete();
            break;
          case "0":
            break loop;
          default:
            System.out.println("잘못된 선택입니다.");
            System.out.println("다시 입력해주세요.");
        }
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }
  }

  private List dramaList = new List();

  public void add() {

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
  }


  public void list() {

    System.out.println("[드라마 목록보기]");

    Object[] list = dramaList.toArray();
    for (Object obj : list) {
      Drama d = (Drama) obj;
      System.out.printf("%s, %s, %s\n," + "%s, %s, %s, %s,\n"
          + "%s,\n" +"%s, %s\n", 
          d.getWhen(), d.getWithWho(), d.getWhere(), 
          d.getTitle(), d.getDirector(), d.getCast(), d.getWriter(), 
          d.getSynop(), d.getMyRating(), d.getRegisteredDate());

    }
  }

  public void detail() {
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

  public void update() {
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
      System.out.println("회원을 변경하였습니다.");

    } else {
      System.out.println("회원 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[드라마 삭제]");

    String title = Prompt.inputString("제목: ");

    Drama drama = findByNo(title);
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
  public String inputDrama(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } 
      if (findByName(name) != null) {
        return name;
      }
      System.out.println("등록된 드라마가 아닙니다.");
    }
  }

  public String inputDramas(String promptTitle) {
    String dramas = "";
    while (true) {
      String name = inputDramas(promptTitle);
      if (name == null) {
        return dramas;
      } else {
        if (!dramas.isEmpty()) {
          dramas += ",";
        }
        dramas += name;
      }
    }
  }

  private Drama findByNo(String dramaTitle) {
    Object[] list = dramaList.toArray();
    for (Object obj : list) {
      // 처음부터 끝까지 찾을 때는 :를 쓰고 아닐 때는 세미콜론을 쓴다.
      Drama d = (Drama) obj;
      if (d.getTitle() == dramaTitle) {
        return d;
      }
    }
    return null;
  }

  private Drama findByName(String title) {
    Object[] list = dramaList.toArray();
    for (Object obj : list) {
      // 처음부터 끝까지 찾을 때는 :를 쓰고 아닐 때는 세미콜론을 쓴다.
      Drama d = (Drama) obj;
      if (d.getTitle().equals(title)) {
        return d;
      }
    }
    return null;
  }
}



