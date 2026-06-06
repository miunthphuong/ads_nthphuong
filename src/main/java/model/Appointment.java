package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Patient patient;
    private Dentist dentist;

    public Appointment() {}

    public Appointment(int appointmentId, LocalDate appointmentDate, LocalTime appointmentTime, Patient patient, Dentist dentist) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.dentist = dentist;
    }

    public int getAppointmentId() { return appointmentId; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public LocalTime getAppointmentTime() { return appointmentTime; }
    public Patient getPatient() { return patient; }
    public Dentist getDentist() { return dentist; }
}