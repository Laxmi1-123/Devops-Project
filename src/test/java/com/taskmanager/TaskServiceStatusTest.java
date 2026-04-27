// src/test/java/com/taskmanager/TaskServiceStatusTest.java
package com.taskmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceStatusTest {

    TaskService service;

    @BeforeEach
    void setup() {
        service = new TaskService();
        service.addTask(new Task(1, "Study", 2));
    }

    @Test
    void shouldMarkTaskDone() {

        boolean result = service.markDone(1);

        assertTrue(result);
        assertTrue(service.getTask(1).isDone());
    }

    @Test
    void markDoneOnInvalidTaskShouldReturnFalse() {

        boolean result = service.markDone(99);

        assertFalse(result);
    }

    @Test
    void newTaskShouldBePending() {

        Task task = service.getTask(1);

        assertFalse(task.isDone());
    }

    @Test
    void markingAlreadyDoneTaskShouldStillBeDone() {

        service.markDone(1);
        boolean result = service.markDone(1);

        assertTrue(result);
        assertTrue(service.getTask(1).isDone());
    }

    @Test
    void markingOneTaskShouldNotAffectOthers() {

        service.addTask(new Task(2, "Code", 1));

        service.markDone(1);

        assertTrue(service.getTask(1).isDone());
        assertFalse(service.getTask(2).isDone());
    }

    @Test
    void shouldReturnCompletedTasksAfterMarkDone() {

        service.markDone(1);

        assertEquals(1, service.getCompletedTasks().size());
    }

    @Test
    void completedTasksShouldBeEmptyInitially() {

        TaskService newService = new TaskService();
        newService.addTask(new Task(2, "Play", 3));

        assertEquals(0, newService.getCompletedTasks().size());
    }

    @Test
    void shouldHandleMultipleCompletedTasks() {

        service.addTask(new Task(2, "Code", 1));
        service.addTask(new Task(3, "Play", 3));

        service.markDone(1);
        service.markDone(2);

        assertEquals(2, service.getCompletedTasks().size());
    }
}