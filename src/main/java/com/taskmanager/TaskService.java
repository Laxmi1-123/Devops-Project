// src/main/java/com/taskmanager/TaskService.java
package com.taskmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {

    private Map<Integer, Task> tasks = new HashMap<>();

    // Add Task
    public void addTask(Task task) {

        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        if (tasks.containsKey(task.getId())) {
            throw new IllegalArgumentException("Task with this ID already exists");
        }

        tasks.put(task.getId(), task);
    }

    // Get Task by ID
    public Task getTask(int id) {
        return tasks.get(id);
    }

    // Get All Tasks
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    // Delete Task
    public boolean deleteTask(int id) {
        return tasks.remove(id) != null;
    }

    // Update Title
    public boolean updateTitle(int id, String title) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        Task task = tasks.get(id);

        if (task == null) {
            return false;
        }

        task.setTitle(title);
        return true;
    }

    // Update Priority
    public boolean updatePriority(int id, int priority) {

        if (priority <= 0) {
            throw new IllegalArgumentException("Invalid priority");
        }

        Task task = tasks.get(id);

        if (task == null) {
            return false;
        }

        task.setPriority(priority);
        return true;
    }

    // Mark Task Done
    public boolean markDone(int id) {

        Task task = tasks.get(id);

        if (task == null) {
            return false;
        }

        task.markDone();
        return true;
    }

    // Search Task by Title
    public List<Task> searchByTitle(String keyword) {

        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(task);
            }
        }

        return result;
    }

    // Get Completed Tasks
    public List<Task> getCompletedTasks() {

        List<Task> completed = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.isDone()) {
                completed.add(task);
            }
        }

        return completed;
    }
}