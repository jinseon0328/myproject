package com.jinseon0328.myproject.domain;

import java.sql.Date;

public class Drama {
  private Date when;
  private String withWho;
  private String where;
  private String title;
  private String director;
  private String cast;
  private String writer;
  private String synop;
  private String myRating;
  private Date registeredDate;



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((director == null) ? 0 : director.hashCode());
    result = prime * result + ((myRating == null) ? 0 : myRating.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((when == null) ? 0 : when.hashCode());
    result = prime * result + ((where == null) ? 0 : where.hashCode());
    result = prime * result + ((withWho == null) ? 0 : withWho.hashCode());
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
    Drama other = (Drama) obj;
    if (director == null) {
      if (other.director != null)
        return false;
    } else if (!director.equals(other.director))
      return false;
    if (myRating == null) {
      if (other.myRating != null)
        return false;
    } else if (!myRating.equals(other.myRating))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (when == null) {
      if (other.when != null)
        return false;
    } else if (!when.equals(other.when))
      return false;
    if (where == null) {
      if (other.where != null)
        return false;
    } else if (!where.equals(other.where))
      return false;
    if (withWho == null) {
      if (other.withWho != null)
        return false;
    } else if (!withWho.equals(other.withWho))
      return false;
    return true;
  }
  public Date getWhen() {
    return when;
  }
  public void setWhen(Date when) {
    this.when = when;
  }
  public String getWithWho() {
    return withWho;
  }
  public void setWithWho(String withWho) {
    this.withWho = withWho;
  }
  public String getWhere() {
    return where;
  }
  public void setWhere(String where) {
    this.where = where;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDirector() {
    return director;
  }
  public void setDirector(String director) {
    this.director = director;
  }
  public String getCast() {
    return cast;
  }
  public void setCast(String cast) {
    this.cast = cast;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getSynop() {
    return synop;
  }
  public void setSynop(String synop) {
    this.synop = synop;
  }
  public String getMyRating() {
    return myRating;
  }
  public void setMyRating(String myRating) {
    this.myRating = myRating;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }



}