package com.jinseon0328.util;

public class Iterator {

  List list;
  int cursor = 0;

  public Iterator(List list) {
    this.list = list;
  }

  public boolean hasNext() {
    return cursor < list.size();
  }

  public Object next() {
    return list.get(cursor++);
  }

}
