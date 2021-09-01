package com.sivanagireddy.singlethread;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ProcessingServiceTest {

  @Disabled
  @Test
  void testAddTask() {
    final ProcessingService processingService = new ProcessingService();
    IntStream.range(1, 10)
        .forEach(i -> processingService.addTask(
            new DatabaseInsertionTask(LocalDateTime.now().minusSeconds(i), Collections.emptyMap()))
        );

    try {
      TimeUnit.MINUTES.sleep(1);
    } catch (InterruptedException e) {
      // NOOP
    }
  }
}