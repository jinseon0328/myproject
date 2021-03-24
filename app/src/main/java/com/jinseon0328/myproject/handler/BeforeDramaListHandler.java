package com.jinseon0328.myproject.handler;

import java.util.Iterator;
import java.util.List;
import com.jinseon0328.myproject.domain.Drama;

public class BeforeDramaListHandler extends AbstractDramaHandler {
  public BeforeDramaListHandler(List<Drama> dramaList) {
    super(dramaList);
  }
  @Override
  public void service() {

    System.out.println("[드라마 목록보기]");

    Iterator<Drama> iterator = dramaList.iterator();

    while (iterator.hasNext()) {
      Drama d = iterator.next();
      System.out.printf("%s, %s, %s\n," + "%s, %s, %s, %s,\n"
          + "%s,\n" +"%s, %s\n", 
          d.getWhen(), 
          d.getWithWho(), 
          d.getWhere(), 
          d.getTitle(), 
          d.getDirector(), 
          d.getCast(), 
          d.getWriter(), 
          d.getSynop(), 
          d.getMyRating(), 
          d.getRegisteredDate());
    }
  }
}
