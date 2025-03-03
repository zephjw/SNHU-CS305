package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;

//Uses HashMap for in-memory storage
//Implements add and delete functionality
public class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private Date futureDate;

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        futureDate = calendar.getTime();
    }

    @Test
    void testAddValidAppointment() {
        Appointment appointment = new Appointment("A123", futureDate, "Test appointment");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("A123"));
    }

    @Test
    void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("A123", futureDate, "Test appointment 1");
        Appointment appointment2 = new Appointment("A123", futureDate, "Test appointment 2");

        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    void testAddNullAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(null);
        });
    }

    @Test
    void testDeleteExistingAppointment() {
        Appointment appointment = new Appointment("A123", futureDate, "Test appointment");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("A123");
        assertNull(appointmentService.getAppointment("A123"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("NonExistent");
        });
    }

    @Test
    void testDeleteWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment(null);
        });
    }
}