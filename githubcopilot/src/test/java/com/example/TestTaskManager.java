package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TestTaskManager {

    @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Task 1", false);
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(1, tasks.size());
        assertEquals("Task 1", tasks.get(0).getDescription());
        assertFalse(tasks.get(0).isDone());
    }

    @Test
    public void testListTasks() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Task 1", false);
        taskManager.addTask("Task 2", true);
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(2, tasks.size());
        assertEquals("Task 1", tasks.get(0).getDescription());
        assertFalse(tasks.get(0).isDone());
        assertEquals("Task 2", tasks.get(1).getDescription());
        assertTrue(tasks.get(1).isDone());
    }

    @Test
    public void testRemoveTask() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Task 1", false);
        taskManager.addTask("Task 2", true);
        taskManager.removeTask(0);
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(1, tasks.size());
        assertEquals("Task 2", tasks.get(0).getDescription());
    }

    @Test
    public void testTaskToString() {
        TaskManager.Task task = new TaskManager.Task("Task 1", false);
        String expected = "Task{description='Task 1', done=false}";
        assertEquals(expected, task.toString());
    }
}