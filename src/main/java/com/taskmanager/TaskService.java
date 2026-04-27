
package com.taskmanager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {

    private Map<Integer, Task> tasks = new HashMap<>();

    public void addTask(Task t) {
        if (t == null) {
            throw new NullPointerException("Task cannot be null");
        }

        if (tasks.containsKey(t.getId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }

        tasks.put(t.getId(), t);
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public boolean deleteTask(int id) {
        return tasks.remove(id) != null;
    }

    public boolean updateTitle(int id, String title) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        Task t = tasks.get(id);

        if (t == null) {
            return false;
        }

        t.setTitle(title);
        return true;
    }

    public boolean markDone(int id) {

        Task t = tasks.get(id);

        if (t == null) {
            return false;
        }

        t.markDone();
        return true;
    }

    public List<Task> getCompletedTasks() {

        List<Task> completed = new ArrayList<>();

        for (Task t : tasks.values()) {
            if (t.isDone()) {
                completed.add(t);
            }
        }

        return completed;
    }
}