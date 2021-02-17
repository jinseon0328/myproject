package com.jinseon0328.myproject.handler;
import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.List;
import com.jinseon0328.util.Prompt;

public class MovieHandler {

  public void service() {
    loop:
      while (true) {
        System.out.println("나의 영화 기록 보관함");
        System.out.println("\t\t:My Cinema\n ");
        System.out.println("1. 본 영화");
        System.out.println("2. 볼 영화");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        switch (command) {
          case "1":
            this.service2();
            break;
          case "2":
            this.service3();
            break;
          case "0":
            break loop;
          default:
            System.out.println("잘못된 선택입니다.");
            System.out.println("다시 입력해주세요.");
        }
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }
  }

  public void service2() {
    loop:
      while (true) {
        System.out.println("이미 본 영화 기록");
        System.out.println("\t\t:My Cinema\n ");
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
              this.add();
              break;
            case "2":
              this.list();
              break;
            case "3":
              this.detail();
              break;
            case "4":
              this.update();
              break;
            case "5":
              this.delete();
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
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }
  }

  public void service3() {
    loop:


      while (true) {
        System.out.println("앞으로 볼 영화 기록");
        System.out.println("\t\t:My Cinema\n ");
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
              this.add();
              break;
            case "2":
              this.list();
              break;
            case "3":
              this.detail();
              break;
            case "4":
              this.update();
              break;

            case "5":
              this.delete();
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
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }
  }

  public List movieList = new List();

  public void add() {

    System.out.println("[영화 기록]");

    Movie m = new Movie();

    m.setTitle(Prompt.inputString("제목: "));
    m.setWithWho(Prompt.inputString("누구와 함께: "));
    m.setWhen(Prompt.inputDate("언제: ")); 
    m.setMyRating(Prompt.inputString("별점: "));

    movieList.add(m);
  }


  public void list() {

    System.out.println("[영화 목록]");

    Object[] list = movieList.toArray();
    for (Object obj : list) {
      Movie m = (Movie) obj;
      System.out.printf("<%s> %s with %s, %s점\n",
          m.getTitle(), m.getWhen(), m.getWithWho(),  m.getMyRating());
    }
  }

  public void detail() {
    System.out.println("[영화 상세 기록]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);

    if (movie == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", movie.getTitle());
    System.out.printf("영화관: %s\n", movie.getWhere());
    System.out.printf("감독: %s\n", movie.getDirector());
    System.out.printf("출연: %s\n", movie.getCast());
    System.out.printf("상영시간: %s\n", movie.getRunningTime());
    System.out.printf("개봉일: %s\n", movie.getReleaseDate());
    System.out.printf("감상: %s\n", movie.getSynop());
    System.out.printf("기록일: %s\n", movie.getRegisteredDate());

  }

  public void update() {
    System.out.println("[영화 변경]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("언제: %s\n", movie.getWhen());
    System.out.printf("누구와 함께: %s\n", movie.getWithWho());
    System.out.printf("제목: %s\n", movie.getTitle());
    System.out.printf("평점: %s\n", movie.getMyRating());

    java.sql.Date when = Prompt.inputDate(String.format("언제: %s -> ", movie.getWhen()));
    String withWho = Prompt.inputString(String.format("누구와 함께: %s -> ", movie.getWithWho()));
    String title1 = Prompt.inputString(String.format("제목: %s -> ", movie.getTitle()));
    String myRating = Prompt.inputString(String.format("평점: %s -> ", movie.getMyRating()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movie.setTitle(title1);
      movie.setWhen(when);
      movie.setWithWho(withWho);
      movie.setWhere(myRating);
      System.out.println("영화를 변경하였습니다.");

    } else {
      System.out.println("영화 변경을 취소하였습니다.");
    }
  }

  public void delete() {
    System.out.println("[영화 삭제]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movieList.delete(title);

      System.out.println("영화를 삭제하였습니다.");

    } else {
      System.out.println("영화 삭제를 취소하였습니다.");
    }

  }

  public String inputMovie(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } 
      if (findByName(name) != null) {
        return name;
      }
      System.out.println("등록된 영화가 아닙니다.");
    }
  }

  public String inputMovies(String promptTitle) {
    String movies = "";
    while (true) {
      String name = inputMovies(promptTitle);
      if (name == null) {
        return movies;
      } else {
        if (!movies.isEmpty()) {
          movies += ",";
        }
        movies += name;
      }
    }
  }

  private Movie findByNo(String MovieTitle) {
    Object[] list = movieList.toArray();
    for (Object obj : list) {
      // 처음부터 끝까지 찾을 때는 :를 쓰고 아닐 때는 세미콜론을 쓴다.
      Movie m = (Movie) obj;
      if (m.getTitle().equals(MovieTitle)) {
        return m;
      }
    }
    return null;
  }

  private Movie findByName(String title) {
    Object[] list = movieList.toArray();
    for (Object obj : list) {
      // 처음부터 끝까지 찾을 때는 :를 쓰고 아닐 때는 세미콜론을 쓴다.
      Movie m = (Movie) obj;
      if (m.getTitle().equals(title)) {
        return m;
      }
    }
    return null;
  }


  public List movieList2 = new List();

  public void add2() {

    System.out.println("[앞으로 볼 영화 기록]");

    Movie m = new Movie();

    m.setTitle(Prompt.inputString("제목: "));
    m.setWhen(Prompt.inputDate("언제: ")); 
    m.setWithWho(Prompt.inputString("누구와 함께: "));
    m.setMyRating(Prompt.inputString("별점: "));

    movieList.add(m);
  }


  public void list2() {

    System.out.println("[영화 목록]");

    Object[] list = movieList.toArray();
    for (Object obj : list) {
      Movie m = (Movie) obj;
      System.out.printf("%s, %s/ <%s> 기대점:%s점\n",
          m.getWhen(), m.getWithWho(), m.getTitle(), m.getMyRating());
    }
  }

  public void detail2() {
    System.out.println("[영화 상세 기록]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);

    if (movie == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", movie.getTitle());
    System.out.printf("영화관: %s\n", movie.getWhere());
    System.out.printf("감독: %s\n", movie.getDirector());
    System.out.printf("출연: %s\n", movie.getCast());
    System.out.printf("상영시간: %s\n", movie.getRunningTime());
    System.out.printf("개봉일: %s\n", movie.getReleaseDate());
    System.out.printf("감상: %s\n", movie.getSynop());
    System.out.printf("기록일: %s\n", movie.getRegisteredDate());

  }

  public void update2() {
    System.out.println("[영화 변경]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 제목의 영화가 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", movie.getTitle());
    System.out.printf("언제: %s\n", movie.getWhen());
    System.out.printf("누구와 함께: %s\n", movie.getWithWho());
    System.out.printf("평점: %s\n", movie.getMyRating());

    java.sql.Date when = Prompt.inputDate(String.format("언제(->%s): ", movie.getWhen()));
    String withWho = Prompt.inputString(String.format("누구와 함께(->%s): ", movie.getWithWho()));
    String myRating = Prompt.inputString(String.format("평점(->%s): ", movie.getMyRating()));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movie.setWhen(when);
      movie.setWithWho(withWho);
      movie.setWhere(myRating);
      System.out.println("영화를 변경하였습니다.");

    } else {
      System.out.println("영화 변경을 취소하였습니다.");
    }
  }

  public void delete2() {
    System.out.println("[영화 삭제]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 영화가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      movieList.delete(title);

      System.out.println("영화를 삭제하였습니다.");

    } else {
      System.out.println("영화 삭제를 취소하였습니다.");
    }

  }

  public String inputMovie2(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } 
      if (findByName(name) != null) {
        return name;
      }
      System.out.println("등록된 영화가 아닙니다.");
    }
  }

  public String inputMovies2(String promptTitle) {
    String movies = "";
    while (true) {
      String name = inputMovies(promptTitle);
      if (name == null) {
        return movies;
      } else {
        if (!movies.isEmpty()) {
          movies += ",";
        }
        movies += name;
      }
    }
  }

  private Movie findByNo2(String MovieTitle) {
    Object[] list = movieList2.toArray();
    for (Object obj : list) {
      // 처음부터 끝까지 찾을 때는 :를 쓰고 아닐 때는 세미콜론을 쓴다.
      Movie m = (Movie) obj;
      if (m.getTitle().equals(MovieTitle)) {
        return m;
      }
    }
    return null;
  }

  private Movie findByName2(String title) {
    Object[] list = movieList2.toArray();
    for (Object obj : list) {
      // 처음부터 끝까지 찾을 때는 :를 쓰고 아닐 때는 세미콜론을 쓴다.
      Movie m = (Movie) obj;
      if (m.getTitle().equals(title)) {
        return m;
      }
    }
    return null;
  }
}










