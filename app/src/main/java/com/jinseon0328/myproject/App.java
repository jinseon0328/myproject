package com.jinseon0328.myproject;
import com.jinseon0328.myproject.handler.BoardHandler;
import com.jinseon0328.myproject.handler.DramaHandler;
import com.jinseon0328.myproject.handler.MovieHandler;
import com.jinseon0328.util.Prompt;

public class App {


  public static void main(String[] args) {

    MovieHandler movieHandler = new MovieHandler();
    DramaHandler dramaHandler = new DramaHandler();
    BoardHandler boardHandler = new BoardHandler(movieHandler);

    loop:
      while (true) {
        System.out.println("My Film Book: ");
        System.out.println("\t나의 영상기록 보관함\n");
        System.out.print("1. 영화\n");
        System.out.print("2. 드라마\n");
        System.out.print("3. 작품 추천\n");
        System.out.println("0. 종료");
        System.out.println();
        System.out.print("\t-모든 메뉴 선택은 숫자로 해주세요\n");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();
        switch (command) {
          case "1":
            movieHandler.service();
            break;
          case "2":
            dramaHandler.service();
            break;
          case "3":
            boardHandler.service();
            break;
          case "0":
            System.out.println("closed Book.");
            break loop;
          default:
            System.out.println("잘못된 선택입니다.");
        }
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }

    Prompt.close();
  }
}