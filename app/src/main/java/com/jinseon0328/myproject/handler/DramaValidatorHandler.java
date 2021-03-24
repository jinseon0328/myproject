package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class DramaValidatorHandler extends AbstractDramaHandler {

  public DramaValidatorHandler(List<Drama> dramaList) {
    super(dramaList);
  }
  @Override
  public void service() {
    // 이 클래스는 실제 사용자의 요청을 처리하지 않는다.
    // 다만 프로젝트와 작업 관련 코드에서 
    // 유효한 회원 이름을 입력 받을 때 사용하기 위해 만든 클래스이다.
    // 그러나 이 클래스도 AbstractMemberHandler를 상속 받았기 때문에
    // Command 규칙에 따라 메서드를 만들어야 한다.
    // 그냥 빈 채로 둔다.
  }

  public String inputDrama(String promptTitle) {
    while (true) {
      String name = Prompt.inputString(promptTitle);
      if (name.length() == 0) {
        return null;
      } 
      if (findByName(name) != null) {
        return name;
      }
      System.out.println("등록된 드라마가 아닙니다.");
    }
  }

  public String inputDramas(String promptTitle) {
    String dramas = "";
    while (true) {
      String name = inputDramas(promptTitle);
      if (name == null) {
        return dramas;
      } else {
        if (!dramas.isEmpty()) {
          dramas += ",";
        }
        dramas += name;
      }
    }
  }

}
