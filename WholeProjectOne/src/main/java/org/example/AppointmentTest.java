package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;


//Tests all Appointment class requirements
public class AppointmentTest {
    
    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    private Date getPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    @Test
    void testValidAppointmentCreation() {
        Appointment appointment = new Appointment("A123", getFutureDate(), "Regular checkup");
        assertNotNull(appointment);
        assertEquals("A123", appointment.getAppointmentId());
        assertEquals("Regular checkup", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", getFutureDate(), "Test"); // > 10 characters
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, getFutureDate(), "Test"); // null
        });
    }

    @Test
    void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", getPastDate(), "Test"); // past date
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", null, "Test"); // null date
        });
    }

    @Test
    void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", getFutureDate(), null); // null description
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A123", getFutureDate(), "This description is way too long and should cause an error because it exceeds fifty characters"); // > 50 characters
        });
    }
}
