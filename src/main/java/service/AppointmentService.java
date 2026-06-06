package service;

import dao.AppointmentDao;
import dto.AppointmentDto;
import model.Appointment;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentService {
    private final AppointmentDao appointmentDao = new AppointmentDao();

    public List<AppointmentDto> getAllAppointmentsSortedDesc() {
        return appointmentDao.getAllAppointments().stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppointmentTime).reversed())
                .map(AppointmentDto::new)
                .collect(Collectors.toList());
    }

    public List<AppointmentDto> getUpcomingQuarterAppointments(LocalDate currentDate) {
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        int currentQuarter = (currentMonth - 1) / 3 + 1;

        int targetQuarter;
        int targetYear;

        if (currentQuarter == 4) {
            targetQuarter = 1;
            targetYear = currentYear + 1;
        } else {
            targetQuarter = currentQuarter + 1;
            targetYear = currentYear;
        }

        return appointmentDao.getAllAppointments().stream()
                .filter(app -> {
                    LocalDate appDate = app.getAppointmentDate();
                    int appQuarter = (appDate.getMonthValue() - 1) / 3 + 1;
                    return appDate.getYear() == targetYear && appQuarter == targetQuarter;
                })
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppointmentTime))
                .map(AppointmentDto::new)
                .collect(Collectors.toList());
    }
}