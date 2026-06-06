package dto;

import model.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {
    private int appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private PatientInfoDto patient;
    private DentistInfoDto dentist;

    public AppointmentDto(Appointment app) {
        this.appointmentId = app.getAppointmentId();
        this.appointmentDate = app.getAppointmentDate();
        this.appointmentTime = app.getAppointmentTime();
        this.patient = new PatientInfoDto(
                app.getPatient().getFirstName(),
                app.getPatient().getLastName(),
                app.getPatient().getPhoneNumber(),
                app.getPatient().getAge()
        );
        this.dentist = new DentistInfoDto(app.getDentist().getName());
    }

    public int getAppointmentId() { return appointmentId; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public LocalTime getAppointmentTime() { return appointmentTime; }
    public PatientInfoDto getPatient() { return patient; }
    public DentistInfoDto getDentist() { return dentist; }

    public static class PatientInfoDto {
        public String firstName;
        public String lastName;
        public String phoneNumber;
        public int age;

        public PatientInfoDto(String fn, String ln, String phone, int age) {
            this.firstName = fn;
            this.lastName = ln;
            this.phoneNumber = phone;
            this.age = age;
        }
    }

    public static class DentistInfoDto {
        public String name;
        public DentistInfoDto(String name) { this.name = name; }
    }
}
