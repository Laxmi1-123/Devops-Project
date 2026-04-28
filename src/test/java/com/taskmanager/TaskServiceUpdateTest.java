package com.taskmanager;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TaskServiceUpdateTest {

    private Map<Integer, Task> taskMap;
    private TaskServiceUpdate taskUpdate;

    @BeforeEach
    void setUp() {
        System.out.println("\n--- New Test Starting ---");
        taskMap = new HashMap<>();
        taskUpdate = new TaskServiceUpdate(taskMap);

        // Sample task
        Task t1 = new Task(1, "Initial Task", 1);
        taskMap.put(1, t1);
    }

    // Test full update
    @Test
    void testUpdateTask_success() {
        System.out.println("Running: testUpdateTask_success");
        Task updated = new Task(1, "Updated Task", 2);

        taskUpdate.updateTask(updated);

        Task result = taskMap.get(1);

        assertEquals("Updated Task", result.getTitle());
        assertEquals(2, result.getPriority());
    }

    // Test update null task
    @Test
    void testUpdateTask_null() {
        System.out.println("Running: testUpdateTask_null");
        assertThrows(NullPointerException.class, () -> {
            taskUpdate.updateTask(null);
        });
    }

    // Test task not found
    @Test
    void testUpdateTask_notFound() {
        System.out.println("Running: testUpdateTask_notFound");
        Task updated = new Task(2, "Task", 1);

        assertThrows(IllegalArgumentException.class, () -> {
            taskUpdate.updateTask(updated);
        });
    }

    // Test update title
    @Test
    void testUpdateTitle_success() {
        System.out.println("Running: testUpdateTitle_success");
        boolean result = taskUpdate.updateTitle(1,"New Title");

        assertTrue(result);
        assertEquals("New Title", taskMap.get(1).getTitle());
    }

    // Invalid title
    @Test
    void testUpdateTitle_invalid() {
        System.out.println("Running: testUpdateTitle_invalid");
        assertThrows(IllegalArgumentException.class, () -> {
            taskUpdate.updateTitle(1,"");
        });
    }

    // Task not found
    @Test
    void testUpdateTitle_notFound() {
        System.out.println("Running: testUpdateTitle_notFound");
        boolean result = taskUpdate.updateTitle(99,"Title");

        assertFalse(result);
    }
    // Mark done
    @Test
    void testMarkDone_success() {
        System.out.println("Running: testMarkDone_success");
        boolean result = taskUpdate.markDone(1);

        assertTrue(result);
        assertTrue(taskMap.get(1).isDone());
    }

    @RepeatedTest(3)
    void testMarkDone_multipleTimes() {
        System.out.println("Running repeated test: markDone");

        taskUpdate.markDone(1);
        assertTrue(taskMap.get(1).isDone());
    }

    // Mark done not found
    @Test
    void testMarkDone_notFound() {
        System.out.println("Running: testMarkDone_notFound");
        boolean result = taskUpdate.markDone(99);

        assertFalse(result);
    }
}