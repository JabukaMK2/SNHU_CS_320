import java.time.LocalDate;
import java.time.format.DateTimeParseException;

// Appointment class, home of the getters and setters
public class Appointment {

    // Appointment shortened to appt for ease, ID and boolean for when its set
    private String apptId;
    private boolean apptIdSet;

    // Date and description (desc) for ease.
    private String apptDate;
    private String apptDesc;

    // Constructor for the appointment object, calls setters
    public Appointment(String apptId, String apptDate, String apptDesc) {
        setApptId(apptId);
        setApptDate(apptDate);
        setApptDesc(apptDesc);
    }

    // Getter for appointment ID
    public String getApptId() {
        return apptId;
    }

    // Setter for appointment ID
    public void setApptId(String apptId) {

        // Checks if appointment ID set boolean is true
        if (apptIdSet) {
            throw new IllegalArgumentException(String.format("%s already exists", apptId));
        }

        // Checks that appointment ID is not null
        else if (apptId == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        // Checks that the length of appointment ID is below 10
        else if (apptId.length() > 10) {
            throw new IllegalArgumentException("ID must be less than 10 characters");
        }

        // Otherwise set the appointment ID and change the appointment set boolean to true
        this.apptId = apptId;
        apptIdSet = true;
    }

    // Getter for appointment date
    public String getApptDate() {
        return apptDate;
    }

    // Setter for appointment date
    public void setApptDate(String apptDate) {

        // If date is null, throw an exception
        if (apptDate == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        // Uses local date to parse appointment date, then get today's date
        LocalDate localDate;

        // Try to parse the appointment date, checking for format issues
        try {
            localDate = LocalDate.parse(apptDate);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(String.format("Invalid date format %s.  Use yyyy-mm-dd (2025-08-03)", apptDate));
        }

        // If the appointment date is in the past, throw an exception
        if (localDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be before today");
        }

        // Otherwise, set the appointment date
        this.apptDate = apptDate;
    }

    // Getter for appointment description
    public String getApptDesc() {
        return apptDesc;
    }

    // Setter for appointment description
    public void setApptDesc(String apptDesc) {
        if (apptDesc == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        else if (apptDesc.length() > 50) {
            throw new IllegalArgumentException("Description must be less than 10 characters");
        }
        this.apptDesc = apptDesc;
    }
}
