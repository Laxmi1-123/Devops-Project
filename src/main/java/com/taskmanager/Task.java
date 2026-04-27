package com.taskmanager;

public class Task {
    private int id;
    private String title;
    private boolean done;
    private int priority;

    public Task(int id, String title, int priority) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be positive");

        if (title == null || title.isBlank())
            throw new IllegalArgumentException("Title required");

        if (priority < 1 || priority > 5)
            throw new IllegalArgumentException("Priority must be between 1 and 5");

        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = false;
    }

    public Task(int id, String title, String priority) {
        this(id, title, convertPriority(priority));
    }

    private static int convertPriority(String priority) {
        if (priority == null)
            throw new IllegalArgumentException("Priority cannot be null");

        return switch (priority.toLowerCase()) {
            case "low" -> 1;
            case "medium" -> 3;
            case "high" -> 5;
            default -> throw new IllegalArgumentException("Invalid priority value");
        };
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isDone() { return done; }
    public int getPriority() { return priority; }

    public void markDone() {
        this.done = true;
    }
}