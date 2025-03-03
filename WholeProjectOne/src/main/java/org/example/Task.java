package org.example;
/*
*John Zephyr
*February 8, 2025
*SC320
*
* */

public class Task {
    private final String id;
    private String name;
    private String description;

    public Task(String id, String name, String description) {
        validateId(id);
        validateName(name);
        validateDescription(description);

        this.id = id;
        this.name = name;
        this.description = description;
    }

    private void validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }
        if (id.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be longer than 10 characters");
        }
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be longer than 20 characters");
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }
}

