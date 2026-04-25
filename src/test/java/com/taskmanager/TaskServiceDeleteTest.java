package com.taskmanager;

import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceDeleteTest {

    TaskServiceDelete deleteService;
    Map<Integer, Task> taskMap;

    @BeforeEach
    void setup() {
        taskMap = new HashMap<>();

        taskMap.put(1, new Task(1, "Test", 1));
        taskMap.put(2, new Task(2, "Second", 2));

        deleteService = new TaskServiceDelete(taskMap);
    }

    @Test
    void shouldDeleteTaskSuccessfully() {
        boolean result = deleteService.deleteTask(1);
        assertTrue(result);
        assertNull(taskMap.get(1));
    }

    @Test
    void deleteAlreadyDeletedTaskShouldReturnFalse() {
        deleteService.deleteTask(1);
        boolean result = deleteService.deleteTask(1);
        assertFalse(result);
    }

    @Test
    void deleteNonExistingTaskShouldReturnFalse() {
        assertFalse(deleteService.deleteTask(100));
    }
}