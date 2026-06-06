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

    // Yêu cầu 4.2.1: Sắp xếp giảm dần theo Ngày và Giờ
    public List<AppointmentDto> getAllAppointmentsSortedDesc() {
        return appointmentDao.getAllAppointments().stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppointmentTime).reversed())
                .map(AppointmentDto::new)
                .collect(Collectors.toList());
    }

    // Yêu cầu 4.2.2: Lọc các cuộc hẹn thuộc Quý tiếp theo và sắp xếp tăng dần
    public List<AppointmentDto> getUpcomingQuarterAppointments(LocalDate currentDate) {
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        // Tính toán Quý hiện tại (1 đến 4)
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