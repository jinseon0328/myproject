package com.jinseon0328.myproject;
import java.util.ArrayList;
import com.jinseon0328.myproject.domain.Board;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.myproject.handler.AfterDramaAddHandler;
import com.jinseon0328.myproject.handler.AfterDramaDeleteHandler;
import com.jinseon0328.myproject.handler.AfterDramaDetailHandler;
import com.jinseon0328.myproject.handler.AfterDramaListHandler;
import com.jinseon0328.myproject.handler.AfterDramaSearchHandler;
import com.jinseon0328.myproject.handler.AfterDramaUpdateHandler;
import com.jinseon0328.myproject.handler.AfterMovieAddHandler;
import com.jinseon0328.myproject.handler.AfterMovieDeleteHandler;
import com.jinseon0328.myproject.handler.AfterMovieDetailHandler;
import com.jinseon0328.myproject.handler.AfterMovieListHandler;
import com.jinseon0328.myproject.handler.AfterMovieSearchHandler;
import com.jinseon0328.myproject.handler.AfterMovieUpdateHandler;
import com.jinseon0328.myproject.handler.BeforeDramaAddHandler;
import com.jinseon0328.myproject.handler.BeforeDramaDeleteHandler;
import com.jinseon0328.myproject.handler.BeforeDramaDetailHandler;
import com.jinseon0328.myproject.handler.BeforeDramaListHandler;
import com.jinseon0328.myproject.handler.BeforeDramaSearchHandler;
import com.jinseon0328.myproject.handler.BeforeDramaUpdateHandler;
import com.jinseon0328.myproject.handler.BeforeMovieAddHandler;
import com.jinseon0328.myproject.handler.BeforeMovieDeleteHandler;
import com.jinseon0328.myproject.handler.BeforeMovieDetailHandler;
import com.jinseon0328.myproject.handler.BeforeMovieListHandler;
import com.jinseon0328.myproject.handler.BeforeMovieSearchHandler;
import com.jinseon0328.myproject.handler.BeforeMovieUpdateHandler;
import com.jinseon0328.myproject.handler.DramaBoardAddHandler;
import com.jinseon0328.myproject.handler.DramaBoardDeleteHandler;
import com.jinseon0328.myproject.handler.DramaBoardDetailHandler;
import com.jinseon0328.myproject.handler.DramaBoardListHandler;
import com.jinseon0328.myproject.handler.DramaBoardSearchHandler;
import com.jinseon0328.myproject.handler.DramaBoardUpdateHandler;
import com.jinseon0328.myproject.handler.MovieBoardAddHandler;
import com.jinseon0328.myproject.handler.MovieBoardDeleteHandler;
import com.jinseon0328.myproject.handler.MovieBoardDetailHandler;
import com.jinseon0328.myproject.handler.MovieBoardListHandler;
import com.jinseon0328.myproject.handler.MovieBoardSearchHandler;
import com.jinseon0328.myproject.handler.MovieBoardUpdateHandler;
import com.jinseon0328.util.Prompt;

public class App {

  // 24-b에 5단계 리팩토링은 메서드가 없는 관계로 실시하지 않았음
  // 24-c에 2단계 AbstractMovieHandler 하는 중

  public static void main(String[] args) throws CloneNotSupportedException {

    ArrayList<Board> dramaboardList = new ArrayList<>();
    DramaBoardAddHandler dramaboardAddHandler = new DramaBoardAddHandler(dramaboardList);
    DramaBoardListHandler dramaboardListHandler = new DramaBoardListHandler(dramaboardList);
    DramaBoardDetailHandler dramaDetailHandler = new DramaBoardDetailHandler(dramaboardList);
    DramaBoardDeleteHandler dramaboardDeleteHandler = new DramaBoardDeleteHandler(dramaboardList);
    DramaBoardUpdateHandler dramaboardUpdateHandler = new DramaBoardUpdateHandler(dramaboardList);
    DramaBoardSearchHandler dramaboardSearchHandler = new DramaBoardSearchHandler(dramaboardList);  

    ArrayList<Board> movieboardList = new ArrayList<>();
    MovieBoardAddHandler movieboardAddHandler = new MovieBoardAddHandler(movieboardList);
    MovieBoardListHandler movieboardListHandler = new MovieBoardListHandler(movieboardList);
    MovieBoardDetailHandler movieDetailHandler = new MovieBoardDetailHandler(movieboardList);
    MovieBoardDeleteHandler movieboardDeleteHandler = new MovieBoardDeleteHandler(movieboardList);
    MovieBoardUpdateHandler movieboardUpdateHandler = new MovieBoardUpdateHandler(movieboardList);
    MovieBoardSearchHandler movieboardSearchHandler = new MovieBoardSearchHandler(movieboardList);  

    ArrayList<Drama> beforedramaList = new ArrayList<>();
    BeforeDramaAddHandler beforedramaAddHandler = new BeforeDramaAddHandler(beforedramaList);
    BeforeDramaListHandler beforedramaListHandler = new BeforeDramaListHandler(beforedramaList);
    BeforeDramaDetailHandler beforedramaDetailHandler = new BeforeDramaDetailHandler(beforedramaList);
    BeforeDramaDeleteHandler beforedramaDeleteHandler = new BeforeDramaDeleteHandler(beforedramaList);
    BeforeDramaUpdateHandler beforedramaUpdateHandler = new BeforeDramaUpdateHandler(beforedramaList);
    BeforeDramaSearchHandler beforedramaSearchHandler = new BeforeDramaSearchHandler(beforedramaList);

    ArrayList<Drama> afterdramaList = new ArrayList<>();
    AfterDramaAddHandler afterdramaAddHandler = new AfterDramaAddHandler(afterdramaList);
    AfterDramaListHandler afterdramaListHandler = new AfterDramaListHandler(afterdramaList);
    AfterDramaDetailHandler afterdramaDetailHandler = new AfterDramaDetailHandler(afterdramaList);
    AfterDramaDeleteHandler afterdramaDeleteHandler = new AfterDramaDeleteHandler(afterdramaList);
    AfterDramaUpdateHandler afterdramaUpdateHandler = new AfterDramaUpdateHandler(afterdramaList);
    AfterDramaSearchHandler afteredramaSearchHandler = new AfterDramaSearchHandler(afterdramaList);

    ArrayList<Movie> beforemovieList = new ArrayList<>();
    BeforeMovieAddHandler beforemovieAddHandler = new BeforeMovieAddHandler(beforemovieList);
    BeforeMovieListHandler beforemovieListHandler = new BeforeMovieListHandler(beforemovieList);
    BeforeMovieDetailHandler beforemovieDetailHandler = new BeforeMovieDetailHandler(beforemovieList);
    BeforeMovieDeleteHandler beforemovieDeleteHandler = new BeforeMovieDeleteHandler(beforemovieList);
    BeforeMovieUpdateHandler beforemovieUpdateHandler = new BeforeMovieUpdateHandler(beforemovieList);
    BeforeMovieSearchHandler beforemovieSearchHandler = new BeforeMovieSearchHandler(beforemovieList);

    ArrayList<Movie> aftermovieList = new ArrayList<>();
    AfterMovieAddHandler aftermovieAddHandler = new AfterMovieAddHandler(aftermovieList);
    AfterMovieListHandler aftermovieListHandler = new AfterMovieListHandler(aftermovieList);
    AfterMovieDetailHandler aftermovieDetailHandler = new AfterMovieDetailHandler(aftermovieList);
    AfterMovieDeleteHandler aftermovieDeleteHandler = new AfterMovieDeleteHandler(aftermovieList);
    AfterMovieUpdateHandler aftermovieUpdateHandler = new AfterMovieUpdateHandler(aftermovieList);
    AfterMovieSearchHandler aftermovieSearchHandler = new AfterMovieSearchHandler(aftermovieList);

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
            afterMovieService();
            break;
          case "2":
            beforeMovieService();
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

  static void afterMovieService() {

    loop:
      while (true) {
        System.out.println("이미 본 영화 기록");
        System.out.print("\t\t:My Cinema\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 기록하기");
        System.out.println("2. 목록보기");
        System.out.println("3. 상세한 내용보기");
        System.out.println("4. 변경하기");
        System.out.println("5. 삭제하기");
        System.out.println("6. 검색하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        try {
          switch (command) {
            case "1":
              AfterMovieAddHandler.add();
              break;
            case "2":
              AfterMovieListHandler.list();
              break;
            case "3":
              AfterMovieDetailHandler.detail();
              break;
            case "4":
              AfterMovieUpdateHandler.update();
              break;
            case "5":
              AfterMovieDeleteHandler.delete();
              break;
            case "6":
              AfterMovieSearchHandler.search();
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

  static void beforeMovieService() {
    loop:
      while (true) {
        System.out.println("앞으로 볼 영화 기록");
        System.out.printf("\t\t:My Cinema\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 기록하기");
        System.out.println("2. 목록보기");
        System.out.println("3. 상세한 내용보기");
        System.out.println("4. 변경하기");
        System.out.println("5. 삭제하기");
        System.out.println("6. 검색하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        try {
          switch (command) {
            case "1":
              BeforeMovieAddHandler.add();
              break;
            case "2":
              BeforeMovieListHandler.list();
              break;
            case "3":
              BeforeMovieDetailHandler.detail();
              break;
            case "4":
              BeforeMovieUpdateHandler.update();
              break;
            case "5":
              BeforeMovieDeleteHandler.delete();
              break;
            case "6":
              BeforeMovieSearchHandler.search();
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
            afterDramaService();
            break;
          case "2":
            beforeDramaService();
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

  static void afterDramaService() {
    loop:
      while (true) {
        System.out.println("이미 본 드라마 기록");
        System.out.printf("\t\t:My Drama\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 기록하기");
        System.out.println("2. 목록보기");
        System.out.println("3. 상세한 내용보기");
        System.out.println("4. 변경하기");
        System.out.println("5. 삭제하기");
        System.out.println("6. 검색하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();
        try {
          switch (command) {
            case "1":
              AfterDramaAddHandler.add();
              break;
            case "2":
              AfterDramaListHandler.list();
              break;
            case "3":
              AfterDramaDetailHandler.detail();
              break;
            case "4":
              AfterDramaUpdateHandler.update();
              break;
            case "5":
              AfterDramaDeleteHandler.delete();
              break;
            case "6":
              AfterDramaSearchHandler.search();
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

  static void beforeDramaService() {
    loop:
      while (true) {
        System.out.println("앞으로 볼 드라마 기록");
        System.out.printf("\t\t:My Drama\n ");
        System.out.println("\t\t------------ ");
        System.out.println("1. 기록하기");
        System.out.println("2. 목록보기");
        System.out.println("3. 상세한 내용보기");
        System.out.println("4. 변경하기");
        System.out.println("5. 삭제하기");
        System.out.println("6. 검색하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        try {
          switch (command) {
            case "1":
              BeforeDramaAddHandler.add();
              break;
            case "2":
              BeforeDramaListHandler.list();
              break;
            case "3":
              BeforeDramaDetailHandler.detail();
              break;
            case "4":
              BeforeDramaUpdateHandler.update();
              break;
            case "5":
              BeforeDramaDeleteHandler.delete();
              break;
            case "6":
              BeforeDramaSearchHandler.search();
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
        System.out.println("6. 추천 영화 검색하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();
        try {
          switch (command) {
            case "1":
              MovieBoardAddHandler.add();
              break;
            case "2":
              MovieBoardListHandler.list();
              break;
            case "3":
              MovieBoardDetailHandler.detail();
              break;
            case "4":
              MovieBoardUpdateHandler.update();
              break;
            case "5":
              MovieBoardDeleteHandler.delete();
              break;
            case "6":
              MovieBoardSearchHandler.search();
              break;
            case "0":
              break loop;
            default:
              System.out.println("선택 번호가 맞지 않습니다.");
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
        System.out.println("6. 추천 드라마 검색하기");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();
        try {
          switch (command) {
            case "1":
              DramaBoardAddHandler.add();
              break;
            case "2":
              DramaBoardListHandler.list();
              break;
            case "3":
              DramaBoardDetailHandler.detail();
              break;
            case "4":
              DramaBoardUpdateHandler.update();
              break;
            case "5":
              DramaBoardDeleteHandler.delete();
              break;
            case "6":
              DramaBoardSearchHandler.search();
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