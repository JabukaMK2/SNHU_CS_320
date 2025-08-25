import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

// Tests the Appointment class
public class AppointmentTest {

    // Tests if an exception is thrown when the appointment ID is too long
    @Test
    public void testCreateLongAppointmentIdFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901","2026-12-25","Christmas party!!");
        });
    }

    // Tests if an exception is thrown when all data is put in as expected
    @Test
    public void testCreateAppointmentSuccess() {
        Assertions.assertDoesNotThrow(() -> {
            Appointment appt = new Appointment("123456","2026-12-25","Christmas party!!");

            assertNotNull(appt);

            assertEquals("123456", appt.getApptId());
            assertEquals("2026-12-25", appt.getApptDate());
            assertEquals("Christmas party!!", appt.getApptDesc());
        });
    }

    // Tests if an exception is thrown when the appointment ID is null
    @Test
    public void testCreateNullApptIdFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null,"2026-12-25","Christmas party!!");
        });
    }

    // Tests if an exception is thrown when the date is in the past
    @Test
    public void testCreatePastApptDateFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456","2024-12-25","Christmas party!!");
        });
    }

    // Tests if an exception is thrown when the date is null
    @Test
    public void testCreateNullApptDateFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456",null,"Christmas party!!");
        });
    }

    // Tests if an exception is thrown when the date is put in incorrectly
    @Test
    public void testFormatApptDateFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456","12-25-2025","Christmas party!!");
        });
    }

    // Tests if an exception is thrown when the description is null
    @Test
    public void testCreateNullApptDescFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456","2026-12-25",null);
        });
    }

    // Tests if an exception is thrown when the description is too long
    @Test
    public void testCreateLongApptDescFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123456","2026-12-25","Christmas party is a time to celebrate christmas and all other holidays as I am super festive and love every holiday and DEMAND presents");
        });
    }
}
