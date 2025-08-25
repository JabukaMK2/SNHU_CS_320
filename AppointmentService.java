import java.util.HashMap;
import java.util.Map;

// Service class for adding and removing appointments
public class AppointmentService {

    // Creates a map for use of creating duplicates
    private Map<String, Appointment> appts = new HashMap<>();

    // Adds appointment if the appointment isn't empty or doesn't already exist
    public void addAppointment(Appointment appt) {
        if (appt == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null or empty");
        }
        else if (appts.containsKey(appt.getApptId())) {
            throw new IllegalArgumentException("Appointment already exists");
        }
        appts.put(appt.getApptId(), appt);
    }

    // Removes the appointment using the appointment ID
    public void deleteAppointment(String apptId) {
        appts.remove(apptId);
    }

    // Returns the appointment for use in JUnit tests
    public Appointment getAppointment(String apptId) {
        return appts.get(apptId);
    }
}
