package com.sivanagireddy.singlethread;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  private final ProcessingService processingService;

  public TaskController(final ProcessingService processingService) {
    this.processingService = processingService;
  }

  @PostMapping("/task/{epochMilli}")
  public ResponseEntity<Map<String, String>> addTask(
      @PathVariable Long epochMilli,
      @RequestBody final Map<String, String> task
  ) {

    final LocalDateTime dateTime = LocalDateTime.ofInstant(
        Instant.ofEpochMilli(epochMilli),
        ZoneOffset.UTC);

    processingService.addTask(new DatabaseInsertionTask(dateTime, task));
    return ResponseEntity.ok(Collections.singletonMap("message", "task added for processing"));
  }
}
