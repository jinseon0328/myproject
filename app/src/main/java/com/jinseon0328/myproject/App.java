package com.jinseon0328.myproject;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
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
  // 24-d 적용하려면 번호 방식을 전부 바꿔야 해서 실시하지 않았음
  // 25 적용하고 있는 중!

  static LinkedList<Board> dramaboardList = new LinkedList<>();
  static ArrayList<Movie> aftermovieList = new ArrayList<>();
  static LinkedList<Board> movieboardList = new LinkedList<>();
  static ArrayList<Drama> beforedramaList = new ArrayList<>();
  static ArrayList<Drama> afterdramaList = new ArrayList<>();
  static ArrayList<Movie> beforemovieList = new ArrayList<>();


  static DramaBoardAddHandler dramaboardAddHandler = new DramaBoardAddHandler(dramaboardList);
  static DramaBoardListHandler dramaboardListHandler = new DramaBoardListHandler(dramaboardList);
  static DramaBoardDetailHandler dramaboardDetailHandler = new DramaBoardDetailHandler(dramaboardList);
  static DramaBoardDeleteHandler dramaboardDeleteHandler = new DramaBoardDeleteHandler(dramaboardList);
  static DramaBoardUpdateHandler dramaboardUpdateHandler = new DramaBoardUpdateHandler(dramaboardList);
  static DramaBoardSearchHandler dramaboardSearchHandler = new DramaBoardSearchHandler(dramaboardList);  

  static MovieBoardAddHandler movieboardAddHandler = new MovieBoardAddHandler(movieboardList);
  static MovieBoardListHandler movieboardListHandler = new MovieBoardListHandler(movieboardList);
  static MovieBoardDetailHandler movieboardDetailHandler = new MovieBoardDetailHandler(movieboardList);
  static MovieBoardDeleteHandler movieboardDeleteHandler = new MovieBoardDeleteHandler(movieboardList);
  static MovieBoardUpdateHandler movieboardUpdateHandler = new MovieBoardUpdateHandler(movieboardList);
  static MovieBoardSearchHandler movieboardSearchHandler = new MovieBoardSearchHandler(movieboardList);  

  static BeforeDramaAddHandler beforedramaAddHandler = new BeforeDramaAddHandler(beforedramaList);
  static BeforeDramaListHandler beforedramaListHandler = new BeforeDramaListHandler(beforedramaList);
  static BeforeDramaDetailHandler beforedramaDetailHandler = new BeforeDramaDetailHandler(beforedramaList);
  static BeforeDramaDeleteHandler beforedramaDeleteHandler = new BeforeDramaDeleteHandler(beforedramaList);
  static BeforeDramaUpdateHandler beforedramaUpdateHandler = new BeforeDramaUpdateHandler(beforedramaList);
  static BeforeDramaSearchHandler beforedramaSearchHandler = new BeforeDramaSearchHandler(beforedramaList);

  static AfterDramaAddHandler afterdramaAddHandler = new AfterDramaAddHandler(afterdramaList);
  static AfterDramaListHandler afterdramaListHandler = new AfterDramaListHandler(afterdramaList);
  static AfterDramaDetailHandler afterdramaDetailHandler = new AfterDramaDetailHandler(afterdramaList);
  static AfterDramaDeleteHandler afterdramaDeleteHandler = new AfterDramaDeleteHandler(afterdramaList);
  static AfterDramaUpdateHandler afterdramaUpdateHandler = new AfterDramaUpdateHandler(afterdramaList);
  static AfterDramaSearchHandler afterdramaSearchHandler = new AfterDramaSearchHandler(afterdramaList);

  static BeforeMovieAddHandler beforemovieAddHandler = new BeforeMovieAddHandler(beforemovieList);
  static BeforeMovieListHandler beforemovieListHandler = new BeforeMovieListHandler(beforemovieList);
  static BeforeMovieDetailHandler beforemovieDetailHandler = new BeforeMovieDetailHandler(beforemovieList);
  static BeforeMovieDeleteHandler beforemovieDeleteHandler = new BeforeMovieDeleteHandler(beforemovieList);
  static BeforeMovieUpdateHandler beforemovieUpdateHandler = new BeforeMovieUpdateHandler(beforemovieList);
  static BeforeMovieSearchHandler beforemovieSearchHandler = new BeforeMovieSearchHandler(beforemovieList);

  static AfterMovieListHandler aftermovieListHandler = new AfterMovieListHandler(aftermovieList);
  static AfterMovieAddHandler aftermovieAddHandler = new AfterMovieAddHandler(aftermovieList);
  static AfterMovieDetailHandler aftermovieDetailHandler = new AfterMovieDetailHandler(aftermovieList);
  static AfterMovieDeleteHandler aftermovieDeleteHandler = new AfterMovieDeleteHandler(aftermovieList);
  static AfterMovieUpdateHandler aftermovieUpdateHandler = new AfterMovieUpdateHandler(aftermovieList);
  static AfterMovieSearchHandler aftermovieSearchHandler = new AfterMovieSearchHandler(aftermovieList);

  public static void main(String[] args){

    loadBoards();


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
              aftermovieAddHandler.service();
              break;
            case "2":
              aftermovieListHandler.service();
              break;
            case "3":
              aftermovieDetailHandler.service();
              break;
            case "4":
              aftermovieUpdateHandler.service();
              break;
            case "5":
              aftermovieDeleteHandler.service();
              break;
            case "6":
              aftermovieSearchHandler.service();
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
              beforemovieAddHandler.service();
              break;
            case "2":
              beforemovieListHandler.service();
              break;
            case "3":
              beforemovieDetailHandler.service();
              break;
            case "4":
              beforemovieUpdateHandler.service();
              break;
            case "5":
              beforemovieDeleteHandler.service();
              break;
            case "6":
              beforemovieSearchHandler.service();
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
              afterdramaAddHandler.service();
              break;
            case "2":
              afterdramaListHandler.service();
              break;
            case "3":
              afterdramaDetailHandler.service();
              break;
            case "4":
              afterdramaUpdateHandler.service();
              break;
            case "5":
              afterdramaDeleteHandler.service();
              break;
            case "6":
              afterdramaSearchHandler.service();
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
              beforedramaAddHandler.service();
              break;
            case "2":
              beforedramaListHandler.service();
              break;
            case "3":
              beforedramaDetailHandler.service();
              break;
            case "4":
              beforedramaUpdateHandler.service();
              break;
            case "5":
              beforedramaDeleteHandler.service();
              break;
            case "6":
              beforedramaSearchHandler.service();
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
              movieboardAddHandler.service();
              break;
            case "2":
              movieboardListHandler.service();
              break;
            case "3":
              movieboardDetailHandler.service();
              break;
            case "4":
              movieboardUpdateHandler.service();
              break;
            case "5":
              movieboardDeleteHandler.service();
              break;
            case "6":
              movieboardSearchHandler.service();
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
              dramaboardAddHandler.service();
              break;
            case "2":
              dramaboardListHandler.service();
              break;
            case "3":
              dramaboardDetailHandler.service();
              break;
            case "4":
              dramaboardUpdateHandler.service();
              break;
            case "5":
              dramaboardDeleteHandler.service();
              break;
            case "6":
              dramaboardSearchHandler.service();
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

  static void loadBoards() {
    try (FileInputStream in = new FileInputStream("boards.data")) {
      // boards.data 파일 포맷에 따라 데이터를 읽는다.
      // 1) 게시글 개수
      int size = in.read() << 8 | in.read();

      // 2) 게시글 개수 만큼 게시글을 읽는다.
      for (int i = 0; i < size; i++) {
        // 게시글 데이터를 저장할 객체 준비
        Board b = new Board();

        // 게시글 데이터를 읽어서 객체에 저장
        // - 게시글 번호를 읽어서 객체에 저장
        int len = in.read() << 8 | in.read();
        byte[] buf = new byte[len];
        in.read(buf);
        b.setName(new String(buf, "UTF-8"));

        // - 게시글 내용을 읽어서 객체에 저장
        len = in.read() << 8 | in.read();
        buf = new byte[len];
        in.read(buf);
        b.setReason(new String(buf, "UTF-8"));

        // - 게시글 작성자 읽어서 객체에 저장
        len = in.read() << 8 | in.read();
        buf = new byte[len];
        in.read(buf);
        b.setWriter(new String(buf, "UTF-8"));

        // - 게시글 등록일을 읽어서 객체에 저장
        len = in.read() << 8 | in.read();
        buf = new byte[len];
        in.read(buf);
        b.setRegisteredDate(Date.valueOf(new String(buf, "UTF-8")));

        // - 게시글 조회수를 읽어서 객체에 저장
        b.setViewCount(in.read() << 24 | in.read() << 16 | in.read() << 8 | in.read());

        // 게시글 객체를 컬렉션에 저장
        dramaboardList.add(b);
      }
      System.out.println("게시글 데이터 로딩!");

    } catch (Exception e) {
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
    }
  }

  static void saveBoards() {
    try (FileOutputStream out = new FileOutputStream("boards.data")) {

      // boards.data 파일 포맷
      // - 2바이트: 저장된 게시글 개수
      // - 게시글 데이터 목록
      //   - 4바이트: 게시글 번호
      //   - 게시글 제목
      //     - 2바이트: 게시글 제목의 바이트 배열 개수
      //     - x바이트: 게시글 제목의 바이트 배열
      //   - 게시글 내용
      //     - 2바이트: 게시글 내용의 바이트 배열 개수
      //     - x바이트: 게시글 내용의 바이트 배열
      //   - 작성자
      //     - 2바이트: 작성자의 바이트 배열 개수
      //     - x바이트: 작성자의 바이트 배열
      //   - 등록일
      //     - 2바이트: 등록일의 바이트 배열 개수
      //     - x바이트: 등록일의 바이트 배열
      //   - 4바이트: 조회수
      int size = dramaboardList.size();
      out.write(size >> 8);
      out.write(size);

      for (Board b : dramaboardList) {
        // 게시글 제목
        byte[] buf = b.getName().getBytes("UTF-8");
        // - 게시글 제목의 바이트 개수
        out.write(buf.length >> 8);
        out.write(buf.length);
        // - 게시글 제목의 바이트 배열
        out.write(buf);

        // 게시글 내용
        buf = b.getReason().getBytes("UTF-8");
        out.write(buf.length >> 8);
        out.write(buf.length);
        out.write(buf);

        // 작성자
        buf = b.getWriter().getBytes("UTF-8");
        out.write(buf.length >> 8);
        out.write(buf.length);
        out.write(buf);

        // 등록일
        buf = b.getRegisteredDate().toString().getBytes("UTF-8");
        out.write(buf.length >> 8);
        out.write(buf.length);
        out.write(buf);

        // 조회수
        out.write(b.getViewCount() >> 24);
        out.write(b.getViewCount() >> 16);
        out.write(b.getViewCount() >> 8);
        out.write(b.getViewCount());
      }
      System.out.println("게시글 데이터 저장!");

    } catch (Exception e) {
      System.out.println("게시글 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }

  static void loadMovies() {

    try (FileInputStream in = new FileInputStream("movies.data")) {

      // 데이터의 개수를 먼저 읽는다. (2바이트)
      int size = in.read() << 8 | in.read();

      for (int i = 0; i < size; i++) {
        // 데이터를 담을 객체 준비
        Movie movie = new Movie();

        // 문자열을 읽을 바이트 배열을 준비한다.
        byte[] bytes = new byte[30000];

        // 출력 형식에 맞춰서 파일에서 데이터를 읽는다.

        // => 영화 이름 읽기
        int len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        movie.setTitle(new String(bytes, 0, len, "UTF-8"));

        // => 영화 관람일 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        movie.setWhen(Date.valueOf(new String(bytes, 0, 10, "UTF-8")));

        // => 영화 동반인 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        movie.setWithWho(new String(bytes, 0, len, "UTF-8"));

        // => 영화 관람 장소 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        movie.setWhere(new String(bytes, 0, len, "UTF-8"));

        // => 영화 감독 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        movie.setDirector(new String(bytes, 0, len, "UTF-8"));

        // => 영화 감독 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        movie.setDirector(new String(bytes, 0, len, "UTF-8"));

        // => 영화 출연진 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        movie.setCast(new String(bytes, 0, len, "UTF-8"));

        // => 영화 러닝타임 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        movie.setRunningTime(new String(bytes, 0, len, "UTF-8"));

        // => 영화 감상 등록일 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, 10);
        movie.setRegisteredDate(Date.valueOf(new String(bytes, 0, 10, "UTF-8")));

        aftermovieList.add(movie);
        beforemovieList.add(movie);
      }
      System.out.println("회원 데이터 로딩!");

    } catch (Exception e) {
      System.out.println("회원 데이터 로딩 중 오류 발생!");
    }
  }

  static void saveMovies() {

    try (FileOutputStream out = new FileOutputStream("movies.data")) {

      // 데이터의 개수를 먼저 출력한다.(2바이트)
      out.write(aftermovieList.size() >> 8);
      out.write(aftermovieList.size());

      for (Aftermovie aftermovie : aftermovieList) {
        // 회원 목록에서 회원 데이터를 꺼내 바이너리 형식으로 출력한다.
        // => 회원 번호 출력 (4바이트)
        out.write(member.getNo() >> 24);
        out.write(member.getNo() >> 16);
        out.write(member.getNo() >> 8);
        out.write(member.getNo());

        // => 회원 이름 
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        byte[] bytes = member.getName().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 회원 이메일 
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = member.getEmail().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 회원 암호 
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = member.getPassword().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 회원 사진 
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = member.getPhoto().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 회원 전화 
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = member.getTel().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 회원 등록일
        //      문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = member.getRegisteredDate().toString().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);
      }
      System.out.println("회원 데이터 저장!");

    } catch (Exception e) {
      System.out.println("회원 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }

  static void loadProjects() {

    try (FileInputStream in = new FileInputStream("projects.data")) {

      // 데이터의 개수를 먼저 읽는다. (2바이트)
      int size = in.read() << 8 | in.read();

      for (int i = 0; i < size; i++) {
        // 데이터를 담을 객체 준비
        Project project = new Project();

        // 출력 형식에 맞춰서 파일에서 데이터를 읽는다.
        // => 프로젝트 번호 읽기
        int value = in.read() << 24;
        value += in.read() << 16;
        value += in.read() << 8;
        value += in.read();
        project.setNo(value);

        // 문자열을 읽을 바이트 배열을 준비한다.
        byte[] bytes = new byte[30000];

        // => 프로젝트 제목 읽기
        int len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        project.setTitle(new String(bytes, 0, len, "UTF-8"));

        // => 프로젝트 내용 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        project.setContent(new String(bytes, 0, len, "UTF-8"));

        // => 프로젝트 시작일 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        project.setStartDate(Date.valueOf(new String(bytes, 0, 10, "UTF-8")));

        // => 프로젝트 종료일 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        project.setEndDate(Date.valueOf(new String(bytes, 0, 10, "UTF-8")));

        // => 프로젝트 소유주 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        project.setOwner(new String(bytes, 0, len, "UTF-8"));

        // => 프로젝트 멤버들 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        project.setMembers(new String(bytes, 0, len, "UTF-8"));

        projectList.add(project);
      }
      System.out.println("프로젝트 데이터 로딩!");

    } catch (Exception e) {
      System.out.println("프로젝트 데이터 로딩 중 오류 발생!");
    }
  }

  static void saveProjects() {

    try (FileOutputStream out = new FileOutputStream("projects.data")) {

      // 데이터의 개수를 먼저 출력한다.(2바이트)
      out.write(projectList.size() >> 8);
      out.write(projectList.size());

      for (Project project : projectList) {
        // 프로젝트 목록에서 프로젝트 데이터를 꺼내 바이너리 형식으로 출력한다.
        // => 프로젝트 번호 출력 (4바이트)
        out.write(project.getNo() >> 24);
        out.write(project.getNo() >> 16);
        out.write(project.getNo() >> 8);
        out.write(project.getNo());

        // => 프로젝트 제목 
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        byte[] bytes = project.getTitle().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 프로젝트 내용
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = project.getContent().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 프로젝트 시작일
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = project.getStartDate().toString().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 프로젝트 종료일 
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = project.getEndDate().toString().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 프로젝트 소유주
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = project.getOwner().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 프로젝트 멤버들
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = project.getMembers().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);
      }
      System.out.println("프로젝트 데이터 저장!");

    } catch (Exception e) {
      System.out.println("프로젝트 데이터를 파일로 저장하는 중에 오류 발생!");
    }
  }

  static void loadTasks() {

    try (FileInputStream in = new FileInputStream("tasks.data")) {

      // 데이터의 개수를 먼저 읽는다. (2바이트)
      int size = in.read() << 8 | in.read();

      for (int i = 0; i < size; i++) {
        // 데이터를 담을 객체 준비
        Task task = new Task();

        // 출력 형식에 맞춰서 파일에서 데이터를 읽는다.
        // => 작업 번호 읽기
        int value = in.read() << 24;
        value += in.read() << 16;
        value += in.read() << 8;
        value += in.read();
        task.setNo(value);

        // 문자열을 읽을 바이트 배열을 준비한다.
        byte[] bytes = new byte[30000];

        // => 작업 내용 읽기
        int len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        task.setContent(new String(bytes, 0, len, "UTF-8"));

        // => 작업 종료일 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        task.setDeadline(Date.valueOf(new String(bytes, 0, 10, "UTF-8")));

        // => 작업 상태 읽기
        value = in.read() << 24;
        value += in.read() << 16;
        value += in.read() << 8;
        value += in.read();
        task.setStatus(value);

        // => 작업 소유주 읽기
        len = in.read() << 8 | in.read();
        in.read(bytes, 0, len);
        task.setOwner(new String(bytes, 0, len, "UTF-8"));

        taskList.add(task);
      }
      System.out.println("작업 데이터 로딩!");

    } catch (Exception e) {
      System.out.println("작업 데이터 로딩 중 오류 발생!");
    }
  }

  static void saveTasks() {

    try (FileOutputStream out = new FileOutputStream("tasks.data")) {

      // 데이터의 개수를 먼저 출력한다.(2바이트)
      out.write(taskList.size() >> 8);
      out.write(taskList.size());

      for (Task task : taskList) {
        // 작업 목록에서 작업 데이터를 꺼내 바이너리 형식으로 출력한다.
        // => 작업 번호 출력 (4바이트)
        out.write(task.getNo() >> 24);
        out.write(task.getNo() >> 16);
        out.write(task.getNo() >> 8);
        out.write(task.getNo());

        // => 작업 내용 
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        byte[] bytes = task.getContent().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 작업 종료일(10바이트)
        bytes = task.getDeadline().toString().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // => 작업 상태 출력 (4바이트)
        out.write(task.getStatus() >> 24);
        out.write(task.getStatus() >> 16);
        out.write(task.getStatus() >> 8);
        out.write(task.getStatus());

        // => 작업 소유주
        //    문자열의 바이트 길이(2바이트) + 문자열의 바이트 배열
        bytes = task.getOwner().getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);
      }
      System.out.println("작업 데이터 저장!");
    }
  }