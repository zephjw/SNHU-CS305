package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddValidTask() {
        Task task = new Task("ID1", "Test Task", "Test Description");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("ID1"));
    }

    @Test
    public void testAddDuplicateTask() {
        Task task1 = new Task("ID1", "Task 1", "Description 1");
        Task task2 = new Task("ID1", "Task 2", "Description 2");

        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("ID1", "Test Task", "Test Description");
        taskService.addTask(task);
        run ( );
        assertNull(taskService.getTask("ID1"));
    }

    @Test
    public void testDeleteNonexistentTask() {
        IllegalArgumentException id1 = Assert.<IllegalArgumentException>assertThrows (IllegalArgumentException.class , this::run);
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("ID1", "Original Name", "Original Description");
        taskService.addTask(task);

        taskService.updateTask("ID1", "New Name", "New Description");
        Task updatedTask = taskService.getTask("ID1");

        assertEquals("New Name", updatedTask.getName());
        assertEquals("New Description", updatedTask.getDescription());
    }

    @Test
    public void testUpdateNonexistentTask() {
        assertThrows(IllegalArgumentException.class,
            () -> taskService.updateTask("ID1", "New Name", "New Description"));
    }

    @Test
    public void testUpdateTaskWithInvalidName() {
        Task task = new Task("ID1", "Original Name", "Original Description");
        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class,
            () -> taskService.updateTask("ID1", null, "New Description"));
        assertThrows(IllegalArgumentException.class,
            () -> taskService.updateTask("ID1", "ThisNameIsTooLongForSystem", "New Description"));
    }

    @Test
    public void testUpdateTaskWithInvalidDescription() {
        Task task = new Task("ID1", "Original Name", "Original Description");
        taskService.addTask(task);

        assertThrows(IllegalArgumentException.class,
            () -> taskService.updateTask("ID1", "New Name", null));
        assertThrows(IllegalArgumentException.class,
            () -> taskService.updateTask("ID1", "New Name", "This description is way too long and should exceed the limit of 50"));
    }

    private void run () {
        taskService.deleteTask ("ID1");
    }
}