package com.taskmanager;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TaskServiceSearchTest {

    TaskServiceSearch service;

    @BeforeEach
    void setup() {

        service = new TaskServiceSearch();

        service.addTask(new Task(1,"Study Java",2));
        service.addTask(new Task(2,"Study DevOps",1));
        service.addTask(new Task(3,"Play Cricket",3));

        service.markDone(2);
    }

    @Test
    void shouldSearchByKeyword() {

        List<Task> result = service.searchByTitle("Study");

        assertEquals(2, result.size());
    }

    @Test
    void searchShouldBeCaseInsensitive() {

        List<Task> result = service.searchByTitle("java");

        assertEquals(1, result.size());
    }

    @Test
    void shouldReturnCompletedTasks() {

        List<Task> completed = service.getCompletedTasks();

        assertEquals(1, completed.size());
    }
}