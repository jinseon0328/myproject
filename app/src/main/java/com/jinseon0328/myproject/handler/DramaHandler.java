package com.jinseon0328.myproject.handler;
import java.sql.Date;
import com.jinseon0328.util.Prompt;


public class DramaHandler {

  static class Drama {
    String title;
    String director;
    String cast;
    String writer;
    String synop;
    String myRating;
    Date registeredDate;
  }

  static final int NUMBER = 100;
  static Drama[] dramas = new Drama[NUMBER];
  static int size = 0;

  public static void add() {

    System.out.println("[감상한 드라마 기록하기]");

    Drama d = new Drama();

    d.title = Prompt.inputString("제목: ");
    d.director = Prompt.inputString("연출: ");
    d.cast = Prompt.inputString("등장인물: ");
    d.writer = Prompt.inputString("극본: ");
    d.synop = Prompt.inputString("줄거리: ");
    d.myRating = Prompt.inputString("별점: ");
    d.registeredDate = new java.sql.Date(System.currentTimeMillis());

    dramas[size++] = d;

  }

  public static void list() {

    System.out.println("[감상한 드라마 목록보기]");

    for (int i = 0; i < size; i++) {
      Drama d = dramas[i];
      System.out.printf("%s, %s, %s, %s, %s, %s, %s\n", 
          d.title, d.director, d.cast, d.writer, 
          d.synop, d.myRating, d.registeredDate);

    }

  }

}

