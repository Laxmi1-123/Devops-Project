package com.taskmanager;

import java.util.Map;

public class TaskServiceUpdate {

    private Map<Integer, Task> tasks;

    // Constructor
    public TaskServiceUpdate(Map<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    // Validation Helper
    private void validateTask(Task task) {
        if (task == null)
            throw new NullPointerException("Task cannot be null");

        if (task.getTitle() == null || task.getTitle().isBlank())
            throw new IllegalArgumentException("Invalid title");
    }

    // Update Full Task
    public void updateTask(Task updatedTask) {
        validateTask(updatedTask);

        Task existing = tasks.get(updatedTask.getId());

        if (existing == null)
            throw new IllegalArgumentException("Task not found");

        existing.setTitle(updatedTask.getTitle());
        existing.setPriority(updatedTask.getPriority());
    }

    // Update Title
    public boolean updateTitle(int id, String title) {

        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Title cannot be empty");

        Task t = tasks.get(id);

        if (t == null)
            return false;

        t.setTitle(title);
        return true;
    }

    // Mark Task Done
    public boolean markDone(int id) {

        Task t = tasks.get(id);

        if (t == null)
            return false;

        t.markDone();
        return true;
    }
}