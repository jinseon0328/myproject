package com.jinseon0328.myproject.handler;

import com.jinseon0328.myproject.domain.Drama;

public class DramaList {
  Node first;
  Node last;
  int size = 0;  

  void add(Drama d) {
    Node node = new Node(d);

    if (last == null) { // 연결 리스트의 첫 항목이라면,
      last = node;
      first = node;
    } else { // 연결리스트에 이미 항목이 있다면, 
      last.next = node; // 현재 마지막 상자의 다음 상자가 새 상자를 가리키게 한다.
      node.prev = last; // 새 상자에서 이전 상자로서 현재 마지막 상자를 가리키게 한다. 
      last = node; // 새 상자가 마지막 상자가 되게 한다.
    }

    size++;
  }
  Drama[] toArray() {
    // 현재까지 저장된 게시글 목록을 리턴하기 위해 새 배열을 준비한다.
    Drama[] arr = new Drama[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.drama;
      cursor = cursor.next;
    }
    return arr;
  }

  Drama get(String dramaTitle) {
    // 해당 번호의 게시글을 찾는다.
    Node cursor = first;
    while (cursor != null) {
      Drama d = cursor.drama;
      if (d.title == dramaTitle) {
        return d;
      }
      cursor = cursor.next;
    }
    return null;
  }

  void delete(String dramaTitle) {
    Drama drama = get(dramaTitle);

    if (drama == null) {
      return;
    }

    Node cursor = first;
    while (cursor != null) {
      if (cursor.drama == drama) {
        if (first == last) {
          first = last = null;
          break;
        }
        if (cursor == first) {
          first = cursor.next;
          cursor.prev = null;
        } else {
          cursor.prev.next = cursor.next;
          if (cursor.next != null) {
            cursor.next.prev = cursor.prev;
          }
        }
        if (cursor == last) {
          last = cursor.prev;
        }
        this.size--;
        break;
      }
      cursor = cursor.next;
    }
  }

  public boolean exist(String title) {
    Node cursor = first;
    while (cursor != null) {
      Drama m = cursor.drama;
      if (m.title.equals(title)) {
        return true;
      }
      cursor = cursor.next;
    }
    return false;
  }


  static class Node {
    Drama drama;
    Node next;
    Node prev;

    Node(Drama d) {
      this.drama = d;
    }
  }
}

