package com.jinseon0328.myproject.handler;

import java.util.List;
import com.jinseon0328.myproject.domain.Drama;

public abstract class AbstractDramaHandler implements Command {

  protected List<Drama> dramaList;

  public AbstractDramaHandler(List<Drama> dramaList) {
    this.dramaList = dramaList;
  }

  public Drama findByNo(String dramaTitle) {
    Drama[] list = dramaList.toArray(new Drama[0]);
    for (Drama d : list) {
      if (d.getTitle().equals(dramaTitle)) {
        return d;
      }
    }
    return null;
  }

  public Drama findByName(String title) {
    Drama[] list = dramaList.toArray(new Drama[0]);
    for (Drama d : list) {
      if (d.getTitle().equals(title)) {
        return d;
      }
    }
    return null;
  }

}
