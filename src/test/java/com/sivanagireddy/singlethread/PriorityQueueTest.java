package com.sivanagireddy.singlethread;

import java.time.LocalDateTime;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PriorityQueueTest {

  @Disabled
  @Test
  void testOrderByTimestamp() {
    LocalDateTime dateTime = LocalDateTime.now();
    LocalDateTime dateTime1 = LocalDateTime.now().minusMinutes(1);
    LocalDateTime dateTime2 = LocalDateTime.now().minusMinutes(2);

    System.out.println(dateTime);
    System.out.println(dateTime1);
    System.out.println(dateTime2);

    PriorityQueue<LocalDateTime> q = new PriorityQueue<>();
    q.offer(dateTime);
    q.offer(dateTime1);
    q.offer(dateTime2);

    q.forEach(System.out::println);
  }

}
