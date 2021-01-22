package com.jinseon0328.myproject;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    Scanner keyboradScan = new Scanner(System.in);

    System.out.println("My Film Book: ");
    System.out.println("\t나의 영상기록 보관함");
    System.out.println();
    System.out.print("1. Netflix [넷플릭스]\n");
    System.out.print("2. watcha [왓챠]\n");
    System.out.println();
    System.out.print("> ");
    System.out.print("\t-모든 메뉴 선택은 숫자로 해주세요\n");


    System.out.println();
    System.out.print("1. 보고 싶은 영화 2. 이미 본 영화\n");
    System.out.print("1. 보고 싶은 드라마 3. 이미 본 드라마\n");
  }
}
