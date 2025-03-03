package org.example;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        String taskId = task.getId();
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(taskId, task);
    }

    public void deleteTask(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Task ID cannot be null");
        }
        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException("Task not found");
        }
        tasks.remove(id);
    }

    public void updateTask(String id, String name, String description) {
        Task task = tasks.get(id);
        if (task == null) {
            throw new IllegalArgumentException("Task not found");
        }
        task.setName(name);
        task.setDescription(description);
    }

    public Task getTask(String id) {
        return tasks.get(id);
    }
}