package com.sivanagireddy.singlethread;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.lang.NonNull;

public class DatabaseInsertionTask implements Runnable {

  private final LocalDateTime localDateTime;
  private final Map<String, String> task;

  public DatabaseInsertionTask(@NonNull final LocalDateTime localDateTime,
      final Map<String, String> task) {
    this.localDateTime = localDateTime;
    this.task = task;
  }

  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      // NOOP
    }
    System.out.println("Inserting " + localDateTime);
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }
}
