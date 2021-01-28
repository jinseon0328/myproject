package com.jinseon0328.myproject;
import com.jinseon0328.myproject.handler.BoardHandler;
import com.jinseon0328.myproject.handler.DramaHandler;
import com.jinseon0328.myproject.handler.MovieHandler;
import com.jinseon0328.util.Prompt;

public class App {

  /* System.out.println("My Film Book: ");
  System.out.println("\t나의 영상기록 보관함\n");
  System.out.println();

  System.out.print("1. CGV [씨지브이]\n");
  System.out.print("2. 메가박스 [megabox]\n");
  System.out.print("3. 롯데시네마 [lettecinema]\n");
  System.out.print("4. Netflix [넷플릭스]\n");
  System.out.print("5. 왓챠 [watcha]\n");
  System.out.println();
  System.out.print("\t-모든 메뉴 선택은 숫자로 해주세요\n");
  System.out.print("> ");*/
  /* 
   * 방식 때문에 고민중...
   */


  public static void main(String[] args) {

    DramaHandler dramaList = new DramaHandler();
    MovieHandler movieList = new MovieHandler();
    BoardHandler boardList = new BoardHandler();

    loop:
      while (true) {
        System.out.println("My Film Book: ");
        System.out.print("1. 영화 기록\n");
        System.out.print("2. 영화 목록\n");
        System.out.print("3. 드라마 기록\n");
        System.out.print("4. 드라마 목록\n");
        System.out.print("5. 영화 추천\n");
        System.out.print("6. 추천한 영화\n");
        System.out.println();
        System.out.print("\t-모든 메뉴 선택은 숫자로 해주세요\n");
        String command = Prompt.inputString("> ");

        switch (command) {
          case "1":
            movieList.add();
            break;
          case "2":
            movieList.list();
            break;
          case "3":
            dramaList.add();
            break;
          case "4":
            dramaList.list();
            break;
          case "5":
            boardList.add(movieList);
            break;
          case "6":
            boardList.list();
            break;
          case "7":
            boardList.detail();
          case "8":
            boardList.update();
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