package com.taskmanager;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceDeleteTest {

    TaskServiceDelete deleteService;
    Map<Integer, Task> taskMap;

    @BeforeEach
    public void setup() {
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