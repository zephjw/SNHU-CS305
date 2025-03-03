package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TaskTest {
    @Test
    public void testValidTask() {
        Task task = new Task("ID1", "Test Task", "Test Description");
        assertEquals("ID1", task.getId());
        assertEquals("Test Task", task.getName());
        assertEquals("Test Description", task.getDescription());
    }

    @Test
    public void testInvalidId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task(null, "Test Task", "Test Description"));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("", "Test Task", "Test Description"));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("12345678901", "Test Task", "Test Description"));
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("ID1", null, "Test Description"));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("ID1", "", "Test Description"));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("ID1", "ThisNameIsTooLongForSystem", "Test Description"));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class,
                () -> new Task("ID1", "Test Task", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("ID1", "Test Task", ""));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("ID1", "Test Task", "This description is way too long and should exceed the limit of 50"));
    }

    @Test
    public void testUpdateFields() {
        Task task = new Task("ID1", "Original Name", "Original Description");
        task.setName("New Name");
        task.setDescription("New Description");

        assertEquals("New Name", task.getName());
        assertEquals("New Description", task.getDescription());
    }

    @Test
    public void testUpdateInvalidFields() {
        Task task = new Task("ID1", "Original Name", "Original Description");

        assertThrows(IllegalArgumentException.class,
                () -> task.setName(null));
        assertThrows(IllegalArgumentException.class,
                () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class,
                () -> task.setName("ThisNameIsTooLongForSystem"));
        assertThrows(IllegalArgumentException.class,
                () -> task.setDescription("This description is way too long and should exceed the limit of 50"));
    }
}