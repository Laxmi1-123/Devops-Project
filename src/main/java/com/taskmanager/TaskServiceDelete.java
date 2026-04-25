package com.taskmanager;

import java.util.Map;

public class TaskServiceDelete {

    private Map<Integer, Task> taskMap;

    public TaskServiceDelete(Map<Integer, Task> taskMap) {
        this.taskMap = taskMap;
    }

    public boolean deleteTask(int id) {
        if (taskMap.containsKey(id)) {
            taskMap.remove(id);
            return true;
        }
        return false;
    }
}