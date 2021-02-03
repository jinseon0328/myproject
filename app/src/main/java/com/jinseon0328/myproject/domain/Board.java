package com.jinseon0328.myproject.domain;

import java.sql.Date;

public class Board {

  private String name;
  private String reason;
  private String writer;
  private Date registeredDate;
  private int viewCount;
  private int like;


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((writer == null) ? 0 : writer.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Board other = (Board) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (writer == null) {
      if (other.writer != null)
        return false;
    } else if (!writer.equals(other.writer))
      return false;
    return true;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getReason() {
    return reason;
  }
  public void setReason(String reason) {
    this.reason = reason;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getLike() {
    return like;
  }
  public void setLike(int like) {
    this.like = like;
  }



}