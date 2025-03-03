package org.example;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    //Implements add and delete functionality
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        
        String appointmentId = appointment.getAppointmentId();
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        
        appointments.put(appointmentId, appointment);
    }

    //validation of ID
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        
        appointments.remove(appointmentId);
    }

    //Maintains uniqueness of ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
