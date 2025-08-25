import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests the AppointmentService class
public class AppointmentServiceTest {

    // Tests if addAppointment throws and exception when duplicate ID is used
    @Test
    public void testAddAppointmentIdFail() {
        AppointmentService appointmentService = new AppointmentService();
        Appointment appt1 = new Appointment("123456","2026-12-25","Christmas party!!");
        Appointment appt2 = new Appointment("123456","2026-08-20","Dance party!!");

        appointmentService.addAppointment(appt1);
        assertThrows(IllegalArgumentException.class, ()->{
            appointmentService.addAppointment(appt2);
        });
    }

    // Tests if any argument is incorrectly thrown when data is correct
    @Test
    public void testAddAppointmentSuccess() {
        AppointmentService service = new AppointmentService();
        Appointment appt1 = new Appointment("123456","2026-12-25","Christmas party!!");

        service.addAppointment(appt1);

        assertEquals(appt1, service.getAppointment(appt1.getApptId()));
    }

    // Tests if addAppointment throws an exception if a null value is given
    @Test
    public void testAddNullAppointmentFail() {
        AppointmentService service = new AppointmentService();
        assertThrows(IllegalArgumentException.class, ()->{
            service.addAppointment(null);
        });
    }

    // Tests if an appointment is deleted properly
    @Test
    public void testDeleteAppointmentSuccess() {
        AppointmentService service = new AppointmentService();
        Appointment appt1 = new Appointment("123456","2026-12-25","Christmas party!!");

        service.addAppointment(appt1);
        service.deleteAppointment(appt1.getApptId());
        assertNull(service.getAppointment(appt1.getApptId()));
    }
}
