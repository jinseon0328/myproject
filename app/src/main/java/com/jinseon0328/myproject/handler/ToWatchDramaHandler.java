package com.jinseon0328.myproject.handler;
import java.util.ArrayList;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.Iterator;
import com.jinseon0328.util.List;
import com.jinseon0328.util.Prompt;

public class ToWatchDramaHandler {

  private List<Drama> dramaList = new List<>();
  private ToWatchDramaHandler toWatchDramaHandler;

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

  public void list() throws CloneNotSupportedException {

    System.out.println("[드라마 목록보기]");

    Iterator<Movie> iterator = new dramaList.iterator;

    while (iterator.hasNext()) {
      Drama d = iterator.next();
      System.out.printf("%s, %s, %s\n," + "%s, %s, %s, %s,\n"
          + "%s,\n" +"%s, %s\n", 
          d.getWhen(), 
          d.getWithWho(), 
          d.getWhere(), 
          d.getTitle(), 
          d.getDirector(), 
          d.getCast(), 
          d.getWriter(), 
          d.getSynop(), 
          d.getMyRating(), 
          d.getRegisteredDate());
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
      dramaList.delete(drama);

      System.out.println("드라마를 삭제하였습니다.");

    } else {
      System.out.println("드라마 삭제를 취소하였습니다.");
    }

    public void search() {
      String keyword = Prompt.inputString("검색할 드라마를 입력해주세요: ");

      if (keyword.length() == 0) {
        System.out.println("검색할 드라마를 입력하세요.");
        return;
      }
      ArrayList<Drama> list = new ArrayList<>();

      Drama[] Dramas = dramaList.toArray(new Drama[dramaList.size()]);
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

      for (Drama m : drama) {
        System.out.printf("<%s> %s with %s, %s점\n",
            m.getTitle(), 
            m.getWhen(), 
            m.getWithWho(),  
            m.getMyRating());
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

    public Drama findByNo(String dramaTitle) {
      Object[] list = dramaList.toArray(new Drama[0]);
      for (Object obj : list) {
        Drama d = (Drama) obj;
        if (d.getTitle().equals(dramaTitle)) {
          return d;
        }
      }
      return null;
    }

    public Drama findByName(String title) {
      Object[] list = dramaList.toArray(new Drama[0]);
      for (Object obj : list) {
        Drama d = (Drama) obj;
        if (d.getTitle().equals(title)) {
          return d;
        }
      }
      return null;
    }

  }