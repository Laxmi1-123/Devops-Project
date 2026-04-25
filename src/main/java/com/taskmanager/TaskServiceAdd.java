package com.taskmanager;

import java.util.*;

public class TaskServiceAdd {

    private Map<Integer, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {

        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        if (taskMap.containsKey(task.getId())) {
            throw new IllegalArgumentException("Task with this ID already exists");
        }

        taskMap.put(task.getId(), task);
    }

    public Task getTask(int id) {
        return taskMap.get(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskMap.values());
    }
}