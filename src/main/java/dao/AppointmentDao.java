package dao;

import model.Appointment;
import model.Dentist;
import model.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
    private final List<Appointment> appointments = new ArrayList<>();

    public AppointmentDao() {
        appointments.add(new Appointment(1, LocalDate.of(2026, 2, 28), LocalTime.of(10, 0),
                new Patient("John", "Smith", "(515) 123-4567", LocalDate.of(1987, 1, 15)), new Dentist("Dr. Geller")));

        appointments.add(new Appointment(2, LocalDate.of(2026, 12, 1), LocalTime.of(13, 45),
                new Patient("Anna", "Jones", "(641) 987-6543", LocalDate.of(2001, 7, 20)), new Dentist("Dr. Green")));

        appointments.add(new Appointment(3, LocalDate.of(2027, 5, 4), LocalTime.of(14, 30),
                new Patient("Carlos", "Jimenez", "(312) 555-0199", LocalDate.of(1978, 10, 5)), new Dentist("Dr. Bing")));

        appointments.add(new Appointment(4, LocalDate.of(2026, 9, 15), LocalTime.of(11, 15),
                new Patient("Albert", "Brooks", "(206) 444-1212", LocalDate.of(1965, 12, 30)), new Dentist("Dr. Geller")));
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}