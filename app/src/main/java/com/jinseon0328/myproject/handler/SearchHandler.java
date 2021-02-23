package com.jinseon0328.myproject.handler;

import com.jinseon0328.myproject.domain.Movie;
import com.jinseon0328.util.List;
import com.jinseon0328.util.Prompt;

public class SearchHandler {

  public void service() {
    loop:
      while (true) {
        System.out.println("나의 영화 기록 보관함");
        System.out.println("\t\t:------------------- ");
        System.out.println("\t\t:My Search\n ");
        System.out.println("1. 영화 검색");
        System.out.println("2. 드라마 검색");
        System.out.println("0. 되돌아가기");

        String command = com.jinseon0328.util.Prompt.inputString("> ");
        System.out.println();

        switch (command) {
          case "1":
            this.movieSearch();
            break;
          case "2":
            this.dramaSearch();
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
  public List movieList = new List();
  public List dramaList2 = new List();
  public List movieList = new List();
  public List dramaList2 = new List();

  public void movieSearch() {
    System.out.println("[영화 검색]");

    String title = Prompt.inputString("제목: ");

    Movie movie = findByNo(title);
    if (movie == null) {
      System.out.println("해당 드라마가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");

    if (input.equalsIgnoreCase("Y")) {
      dramaList.delete(title);

      System.out.println("드라마를 삭제하였습니다.");

    } else {
      System.out.println("드라마 삭제를 취소하였습니다.");
    }

  }
  public void search() {
    Movie[] ms = new Movie[index];
    for(int i = 0; i < index; i++) {
      if(movies[i] != null) {
        ms[i] = movies[i];
      }
    }
    return ms;
  }
}