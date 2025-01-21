package com.example;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
    private List<Task> tasks = new CopyOnWriteArrayList<>();

    /**
     * Adds a new task to the task list.
     * @param description the description of the task
     * @param isDone the status of the task
     * @throws IllegalArgumentException if the description is null or empty
     */
    public void addTask(String description, boolean isDone) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty");
        }
        tasks.add(new Task(description, isDone));
    }

    /**
     * Lists all tasks.
     * @return an unmodifiable list of tasks
     */
    public List<Task> listTasks() {
        return Collections.unmodifiableList(tasks);
    }

    /**
     * Removes a task at the specified index.
     * @param index the index of the task to remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid task index");
        }
    }

    public static class Task {
        private String description;
        private boolean isDone;

        public Task(String description, boolean isDone) {
            this.description = description;
            this.isDone = isDone;
        }

        public String getDescription() {
            return description;
        }

        public boolean isDone() {
            return isDone;
        }

        @Override
        public String toString() {
            return "Task{description='" + description + "', done=" + isDone + "}";
        }
    }
}