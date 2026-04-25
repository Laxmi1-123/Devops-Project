package com.taskmanager;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceAddTest {

    TaskServiceAdd service;

    @BeforeEach
    void setup() {
        service = new TaskServiceAdd();
    }

    @Test
    void shouldAddTask() {
        service.addTask(new Task(1, "Study", 2));
        assertNotNull(service.getTask(1));
    }

    @Test
    void shouldNotAllowDuplicateId() {
        service.addTask(new Task(1, "Study", 2));

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task(1, "Duplicate", 3));
        });

        assertEquals("Task with this ID already exists", e.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(null);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(0, "Study", 2);
        });
    }

    @Test
    void shouldThrowExceptionForEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(1, "", 2);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidPriority() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(1, "Study", 0);
        });
    }
}