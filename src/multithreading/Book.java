package multithreading;

import java.util.concurrent.Semaphore;

public class Book {
  int count = 50;
  Semaphore semaphore = new Semaphore(50);

  public Book() {
  }

  ;

  public void borrowBook() {
    synchronized (this) {
      try {
        semaphore.acquire();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("ban da thue sach thanh cong");
    }
    try {
      Thread.sleep(2000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    synchronized (this) {
      count--;
    }
  }

}
