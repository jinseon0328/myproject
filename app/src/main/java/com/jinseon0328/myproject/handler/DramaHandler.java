package com.jinseon0328.myproject.handler;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class DramaHandler {

  static final int NUMBER = 100;
  Drama[] dramas = new Drama[NUMBER];
  int size = 0;

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


    this.dramas[this.size++] = d;

  }

  public void list() {

    System.out.println("[드라마 목록보기]");

    for (int i = 0; i < this.size; i++) {
      Drama d = this.dramas[i];
      System.out.printf("%s, %s, %s\n," + "%s, %s, %s, %s,\n"
          + "%s,\n" +"%s, %s\n", 
          d.when, d.withWho, d.where, 
          d.title, d.director, d.cast, d.writer, 
          d.synop, d.myRating, d.registeredDate );

    }

  }

}

