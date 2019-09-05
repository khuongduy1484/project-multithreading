package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo {
  public static void main(String[] args) {
    Book book = new Book();
    book.borrowBook();

    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i <= 1000; i++) {
      executorService.submit(new Runnable() {
        @Override
        public void run() {
          book.borrowBook();
        }
      });
    }

    executorService.shutdown();
    try {
      executorService.awaitTermination(1, TimeUnit.DAYS);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
