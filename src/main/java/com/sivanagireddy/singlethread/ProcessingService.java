package com.sivanagireddy.singlethread;

import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ProcessingService {

  private static final int MAX_TASKS_TO_HOLD = 10;

  private final Executor threadPool =
      new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,
          new PriorityBlockingQueue<Runnable>(MAX_TASKS_TO_HOLD, new DatabaseTaskComparator()));


  public void addTask(final DatabaseInsertionTask task) {
    threadPool.execute(task);
  }
}
