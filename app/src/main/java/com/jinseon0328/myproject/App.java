package com.jinseon0328.myproject;
import com.jinseon0328.myproject.handler.AfterDramaHandler;
import com.jinseon0328.myproject.handler.AfterMovieHandler;
import com.jinseon0328.myproject.handler.BeforeDramaHandler;
import com.jinseon0328.myproject.handler.BeforeMovieHandler;
import com.jinseon0328.myproject.handler.DramaBoardHandler;
import com.jinseon0328.myproject.handler.MovieBoardHandler;
import com.jinseon0328.util.Prompt;

// search() 가능하게 만들고
// map 사용하게 하고
// 21-a 까지 적용

public class App {

  static AfterMovieHandler afterMovieHandler = new AfterMovieHandler();
  static BeforeMovieHandler beforeMovieHandler= new BeforeMovieHandler();
  static AfterDramaHandler afterDramaHandler = new AfterDramaHandler();
  static BeforeDramaHandler toWatcheDramaHandler = new BeforeDramaHandler();
  static DramaBoardHandler dramaBoardHandler = new DramaBoardHandler(afterDramaHandler);
  static MovieBoardHandler movieBoardHandler = new MovieBoardHandler(afterMovieHandler);

  public static void main(String[] args) throws CloneNotSupportedException {

    loop:
      while (true) {
        System.out.println("My Film Book: ");
        System.out.println("\t나의 영상기록 보관함\n");
        System.out.print("1. 영화\n");
        System.out.print("2. 드라마\n");
        System.out.print("3. 영화 추천\n");
        System.out.print("4. 드라마 추천\n");
        System.out.println("0. 종료");
        System.out.println();
        System.out.print("\t-모든 메뉴 선택은 숫자로 해주세요\n");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();
        switch (command) {
          case "1":
            movieService();
            break;
          case "2":
            dramaService();
            break;
          case "3":
            movieBoardService();
            break;
          case "4":
            dramaBoardService();
          case "0":
            System.out.println("closed Book.");
            break loop;
          default:
            System.out.println("잘못된 선택입니다.");
        }
        System.out.println(); 
      }

    Prompt.close();
  }

  static void movieService() {
    loop:
      while (true) {
        System.out.println("나의 영화 기록 보관함");
        System.out.print("\t\t: My Cinema\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 본 영화");
        System.out.println("2. 볼 영화");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        switch (command) {
          case "1":
            watchedMovieService();
            break;
          case "2":
            toWatchMovieService();
            break;
          case "0":
            break loop;
          default:
            System.out.println("잘못된 선택입니다.");
            System.out.println("다시 입력해주세요.");
        }
        System.out.println(); 
      }
  }

  static void watchedMovieService() {
    loop:
      while (true) {
        System.out.println("이미 본 영화 기록");
        System.out.print("\t\t:My Cinema\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 본 영화 기록");
        System.out.println("2. 본 영화 목록");
        System.out.println("3. 본 영화 상세");
        System.out.println("4. 본 영화 변경");
        System.out.println("5. 본 영화 삭제");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        try {
          switch (command) {
            case "1":
              afterMovieHandler.add();
              break;
            case "2":
              afterMovieHandler.list();
              break;
            case "3":
              afterMovieHandler.detail();
              break;
            case "4":
              afterMovieHandler.update();
              break;
            case "5":
              afterMovieHandler.delete();
              break;
            case "0":
              break loop;
            default:
              System.out.println("잘못된 선택입니다.");
              System.out.println("다시 입력해주세요.");
          }
        } catch (Exception e) {
          System.out.println("------------------------------------------------");
          System.out.printf("명령어 실행 중 오류 발생 :%s - %s\n", 
              e.getClass().getName(), e.getMessage());
        }
        System.out.println(); 
      }
  }

  static void toWatchMovieService() {
    loop:
      while (true) {
        System.out.println("앞으로 볼 영화 기록");
        System.out.printf("\t\t:My Cinema\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 볼 영화 기록");
        System.out.println("2. 볼 영화 목록");
        System.out.println("3. 볼 영화 상세");
        System.out.println("4. 볼 영화 변경");
        System.out.println("5. 볼 영화 삭제");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        try {
          switch (command) {
            case "1":
              beforeMovieHandler.add();
              break;
            case "2":
              beforeMovieHandler.list();
              break;
            case "3":
              beforeMovieHandler.detail();
              break;
            case "4":
              beforeMovieHandler.update();
              break;
            case "5":
              beforeMovieHandler.delete();
              break;
            case "0":
              break loop;
            default:
              System.out.println("잘못된 선택입니다.");
              System.out.println("다시 입력해주세요.");
          }
        } catch (Exception e) {
          System.out.println("------------------------------------------------");
          System.out.printf("명령어 실행 중 오류 발생 :%s - %s\n", 
              e.getClass().getName(), e.getMessage());
          System.out.println("------------------------------------------------");
        }
        System.out.println(); 
      }
  }

  static void dramaService() {
    loop:
      while (true) {
        System.out.println("나의 드라마 기록 보관함");
        System.out.printf("\t\t:My Drama\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 본 드라마");
        System.out.println("2. 볼 드라마");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        switch (command) {
          case "1":
            wathedDramaService();
            break;
          case "2":
            toWatchDramaService();
            break;
          case "0":
            break loop;
          default:
            System.out.println("잘못된 선택입니다.");
            System.out.println("다시 입력해주세요.");
        }
        System.out.println(); 
      }
  }

  static void wathedDramaService() {
    loop:
      while (true) {
        System.out.println("이미 본 드라마 기록");
        System.out.printf("\t\t:My Drama\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 드라마 기록");
        System.out.println("2. 드라마 목록");
        System.out.println("3. 드라마 상세");
        System.out.println("4. 드라마 변경");
        System.out.println("5. 드라마 삭제");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();
        try {
          switch (command) {
            case "1":
              afterDramaHandler.add();
              break;
            case "2":
              afterDramaHandler.list();
              break;
            case "3":
              afterDramaHandler.detail();
              break;
            case "4":
              afterDramaHandler.update();
              break;
            case "5":
              afterDramaHandler.delete();
              break;
            case "0":
              break loop;
            default:
              System.out.println("잘못된 선택입니다.");
              System.out.println("다시 입력해주세요.");
          }
        } catch (Exception e) {
          System.out.println("------------------------------------------------");
          System.out.printf("명령어 실행 중 오류 발생 :%s - %s\n", 
              e.getClass().getName(), e.getMessage());
          System.out.println("------------------------------------------------");
        }
        System.out.println(); 

      }
  }

  static void toWatchDramaService() {
    loop:
      while (true) {
        System.out.println("앞으로 볼 드라마 기록");
        System.out.printf("\t\t:My Drama\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 드라마 기록");
        System.out.println("2. 드라마 목록");
        System.out.println("3. 드라마 상세");
        System.out.println("4. 드라마 변경");
        System.out.println("5. 드라마 삭제");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        try {
          switch (command) {
            case "1":
              beforeMovieHandler.add();
              break;
            case "2":
              beforeMovieHandler.list();
              break;
            case "3":
              beforeMovieHandler.detail();
              break;
            case "4":
              beforeMovieHandler.update();
              break;
            case "5":
              beforeMovieHandler.delete();
              break;
            case "0":
              break loop;
            default:
              System.out.println("잘못된 선택입니다.");
              System.out.println("다시 입력해주세요.");
          }
        } catch (Exception e) {
          System.out.println("------------------------------------------------");
          System.out.printf("명령어 실행 중 오류 발생 :%s - %s\n", 
              e.getClass().getName(), e.getMessage());
          System.out.println("------------------------------------------------");
        }
        System.out.println(); 
      }
  }

  static void movieBoardService() {
    loop:
      while (true) {
        System.out.println("작품 추천: ");
        System.out.println("\t내가 추천하는 작품들\n");
        System.out.println("1. 추천 영화 등록하기");
        System.out.println("2. 추천 영화 목록보기");
        System.out.println("3. 추천 영화 상세보기");
        System.out.println("4. 추천 영화 변경하기");
        System.out.println("5. 추천 영화 삭제하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();
        try {
          switch (command) {
            case "1":
              movieBoardHandler.movieAdd();
              break;
            case "2":
              movieBoardHandler.movieList();
              break;
            case "3":
              movieBoardHandler.movieDetail();
              break;
            case "4":
              movieBoardHandler.movieUpdate();
              break;
            case "5":
              movieBoardHandler.movieDelete();
              break;
            case "0":
              break loop;
            default:
              System.out.println("메뉴 번호가 맞지 않습니다.");
          }
        } catch (Exception e) {
          System.out.println("------------------------------------------------");
          System.out.printf("명령어 실행 중 오류 발생 :%s - %s\n", 
              e.getClass().getName(), e.getMessage());
          System.out.println("------------------------------------------------");
        }
        System.out.println();
      }
  }

  static void dramaBoardService() {
    loop:
      while (true) {
        System.out.println("작품 추천: ");
        System.out.println("\t내가 추천하는 드라마\n");
        System.out.println("1. 추천 드라마 등록하기");
        System.out.println("2. 추천 드라마 목록보기");
        System.out.println("3. 추천 드라마 상세보기");
        System.out.println("4. 추천 드라마 변경하기");
        System.out.println("5. 추천 드라마 삭제하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();
        try {
          switch (command) {
            case "1":
              dramaBoardHandler.dramaAdd();
              break;
            case "2":
              dramaBoardHandler.dramaList();
              break;
            case "3":
              dramaBoardHandler.dramaDetail();
              break;
            case "4":
              dramaBoardHandler.dramaUpdate();
              break;
            case "5":
              dramaBoardHandler.dramaDelete();
              break;
            case "0":
              break loop;
            default:
              System.out.println("메뉴 번호가 맞지 않습니다.");
          }
        } catch (Exception e) {
          System.out.println("------------------------------------------------");
          System.out.printf("명령어 실행 중 오류 발생 :%s - %s\n", 
              e.getClass().getName(), e.getMessage());
          System.out.println("------------------------------------------------");
        }
        System.out.println();
      }
  }
}