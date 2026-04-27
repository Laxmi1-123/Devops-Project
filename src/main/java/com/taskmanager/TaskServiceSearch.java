package com.taskmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskServiceSearch {

    private Map<Integer, Task> tasks = new HashMap<>();

    // Add Task (needed for testing)
    public void addTask(Task t) {
        tasks.put(t.getId(), t);
    }

    // Search by title
    public List<Task> searchByTitle(String keyword) {

        if (keyword == null || keyword.isBlank()) {
            return new ArrayList<>();
        }

        List<Task> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Task t : tasks.values()) {
            if (t.getTitle().toLowerCase().contains(lowerKeyword)) {
                result.add(t);
            }
        }

        return result;
    }

    // Get completed tasks
    public List<Task> getCompletedTasks() {

        List<Task> completed = new ArrayList<>();

        for (Task t : tasks.values()) {
            if (t.isDone()) {
                completed.add(t);
            }
        }

        return completed;
    }

    // Mark task done (needed for test)
    public void markDone(int id) {
        Task t = tasks.get(id);
        if (t != null) {
            t.markDone();
        }
    }
}