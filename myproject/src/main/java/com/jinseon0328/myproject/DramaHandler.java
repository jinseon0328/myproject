package com.jinseon0328.myproject;
import java.sql.Date;


public class DramaHandler {

  static final int DNUMBER = 100;
  static String[] dtitle = new String[DNUMBER];
  static String[] ddirector = new String[DNUMBER];
  static String[] dcast = new String[DNUMBER];
  static String[] dwriter = new String[DNUMBER];
  static String[] dsynop = new String[DNUMBER];
  static String[] dmyRating = new String[DNUMBER];
  static Date[] registeredDate = new Date[DNUMBER];
  static int dsize = 0;


  static void add() {

    System.out.println("[드라마 등록]");

    dtitle[dsize] = Prompt.inputString("제목: ");
    ddirector[dsize] = Prompt.inputString("연출: ");
    dcast[dsize] = Prompt.inputString("등장인물: ");
    dwriter[dsize] = Prompt.inputString("극본: ");
    dsynop[dsize] = Prompt.inputString("줄거리: ");
    dmyRating[dsize] = Prompt.inputString("별점: ");
    registeredDate[dsize] = new java.sql.Date(System.currentTimeMillis());

    dsize++;

  }

  static void list() {

    System.out.println("[드라마 목록]");

    for (int i = 0; i < dsize; i++) {
      System.out.printf("%s, %s, %s, %s, %s, %s, %s\n", 
          dtitle[i], ddirector[i], dcast[i], dwriter[i], 
          dsynop[i], dmyRating[i], registeredDate[i]);

    }

  }

}

