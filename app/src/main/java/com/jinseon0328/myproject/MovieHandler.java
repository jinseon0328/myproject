package com.jinseon0328.myproject;
import java.sql.Date;

public class MovieHandler {

  static final int NUMBER = 100;
  static String[] title = new String[NUMBER];
  static String[] director = new String[NUMBER];
  static String[] cast = new String[NUMBER];
  static String[] runningTime = new String[NUMBER];
  static Date[] releaseDate = new Date[NUMBER];
  static String[] synop = new String[NUMBER];
  static String[] myRating = new String[NUMBER];
  static Date[] registeredDate = new Date[NUMBER];
  static int size = 0;


  static void add() {

    System.out.println("[영화 기록]");



    title[size] = Prompt.inputString("제목: ");
    director[size] = Prompt.inputString("감독: ");
    cast[size] = Prompt.inputString("출연: ");
    runningTime[size] = Prompt.inputString("상영시간: ");
    releaseDate[size] = Prompt.inputDate("개봉일: ");
    synop[size] = Prompt.inputString("줄거리: ");
    myRating[size] = Prompt.inputString("별점: ");
    registeredDate[size] = new java.sql.Date(System.currentTimeMillis());
    size++;
  }


  static void list() {
    System.out.println("[영화 리스트]");

    for (int i = 0; i < size; i++) {
      System.out.printf("%s, %s, %s, %s, %s, %s, %s, %s\n",
          title[i], director[i], cast[i], runningTime[i], releaseDate[i], 
          synop[i], myRating[i], registeredDate[i]);

    }

  }

}

