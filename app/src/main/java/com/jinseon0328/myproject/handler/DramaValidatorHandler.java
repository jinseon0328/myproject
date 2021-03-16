package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Drama;
import com.jinseon0328.util.Prompt;

public class DramaValidatorHandler extends AbstractDramaHandler {

  public DramaValidatorHandler(List<Drama> dramaList) {
    super(dramaList);
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
