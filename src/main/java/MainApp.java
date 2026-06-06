import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dto.AppointmentDto;
import service.AppointmentService;

import java.time.LocalDate;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AppointmentService service = new AppointmentService();

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            System.out.println("======================================================================");
            System.out.println("REQUIRMENT 4.2.1: All Appointments (Sorted by Date/Time Descending)");
            System.out.println("======================================================================");
            List<AppointmentDto> allApps = service.getAllAppointmentsSortedDesc();
            System.out.println(mapper.writeValueAsString(allApps));

            System.out.println("\n======================================================================");
            System.out.println("REQUIRMENT 4.2.2: Quarterly Upcoming Appointments (Current Date: 2026-June-06)");
            System.out.println("======================================================================");
            // Theo đề bài: Ngày hiện tại là 2026-06-06 (Q2) -> Quý tiếp theo là Q3/2026 (Tháng 7, 8, 9)
            LocalDate currentDate = LocalDate.of(2026, 6, 6);
            List<AppointmentDto> quarterlyApps = service.getUpcomingQuarterAppointments(currentDate);
            System.out.println(mapper.writeValueAsString(quarterlyApps));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}