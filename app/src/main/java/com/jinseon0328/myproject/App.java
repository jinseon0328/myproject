package com.jinseon0328.myproject;

public class App {


  public static void main(String[] args) {



    loop:

      while (true) {

        System.out.println("My Film Book: ");
        System.out.println("1. 감상한 영화 기록하기\n2. 감상한 영화 목록보기\n"
            +"3. 감상한 드라마 기록하기\n4. 감상한 드라마 목록보기\n");
        String command = Prompt.inputString("> ");



        switch (command) {

          case "1":

            MovieHandler.add();

            break;

          case "2":

            MovieHandler.list();

            break;

          case "3":

            DramaHandler.add();

            break;

          case "4":

            DramaHandler.list();

            break;

          case "quit":

          case "exit":

            System.out.println("close Book!");

            break loop;

          default:

            System.out.println("실행할 수 없는 명령입니다.");

        }

        System.out.println(); 

      }



    Prompt.close();

  }

}