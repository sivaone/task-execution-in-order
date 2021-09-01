package com.sivanagireddy.singlethread;

import java.util.Comparator;
import org.springframework.lang.NonNull;

public class DatabaseTaskComparator<T extends DatabaseInsertionTask> implements Comparator<T> {

  @Override
  public int compare(@NonNull final T o1, @NonNull final T o2) {
    return o1.getLocalDateTime().compareTo(o2.getLocalDateTime());
  }
}
