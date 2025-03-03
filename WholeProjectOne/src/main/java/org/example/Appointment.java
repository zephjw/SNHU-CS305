
/*
*John Zephyr
*February 16, 2025
*SC320
*
* */
package org.example;
import java.util.Date;

public class Appointment {
    private final String appointmentId;
    private Date appointmentDate;
    private String description;


    //Implements all required fields with proper validation
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        validateAppointmentId(appointmentId);
        validateAppointmentDate(appointmentDate);
        validateDescription(description);

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }


    //appointmentId validation
    private void validateAppointmentId(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        if (appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be longer than 10 characters");
        }
    }


    //Date validation
    private void validateAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }
    }

    //Description length validation
    private void validateDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }
    }


    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // Setters with validation
    public void setAppointmentDate(Date appointmentDate) {
        validateAppointmentDate(appointmentDate);
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }
}

