package com.jinseon0328.myproject;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);

    final int NUMBER = 100;
    int[] no = new int[NUMBER];
    String[] name = new String[NUMBER];
    String[] email = new String[NUMBER];
    String[] password = new String[NUMBER];
    String[] photo = new String[NUMBER];
    String[] tel = new String[NUMBER];
    Date[] registeredDate = new Date[NUMBER];

    int size = 0;

    loop:
      while (true) {
        System.out.print("명령> ");
        String command = keyboardScan.nextLine();

        switch (command) {
          case "/member/add":
            System.out.println("[대출회원 등록]");

            System.out.print("번호? ");
            no[size] = Integer.parseInt(keyboardScan.nextLine());

            System.out.print("이름? ");
            name[size] = keyboardScan.nextLine();

            System.out.print("이메일? ");
            email[size] = keyboardScan.nextLine();

            System.out.print("암호? ");
            password[size] = keyboardScan.nextLine();

            System.out.print("사진? ");
            photo[size] = keyboardScan.nextLine();

            System.out.print("전화? ");
            tel[size] = keyboardScan.nextLine();

            registeredDate[size] = new java.sql.Date(System.currentTimeMillis());

            size++;
            break;
          case "/member/list":
            System.out.println("[대출회원 목록]");
            for (int i = 0; i < size; i++) {
              System.out.printf("%d, %s, %s, %s, %s\n",
                  no[i], name[i], email[i], tel[i], registeredDate[i]);
            }
            break;
          case "quit":
          case "exit":
            System.out.println("종료");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }
        System.out.println(); 
      }

    keyboardScan.close();
  }
}
