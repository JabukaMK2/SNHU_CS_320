import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    // Checks if the code sends and exception for bad data
    @Test
    public void testCreateContactFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901","Eric","Schooler-Davison","7858421212","111 1ST");
        });
    }

    // Checks if the contact system successfully adds a contact if it meets all requirements
    @Test
    public void testCreateContactSuccess() {
        Assertions.assertDoesNotThrow(() -> {
            Contact contact = new Contact("123456","Eric","Schooler","7858421212","111 First Street");

            assertNotNull(contact);

            assertEquals("123456", contact.getContactId());

            assertEquals("Eric", contact.getFirst());
        });
    }

    // Checks if ID creation throws and exception for too long or null
    @Test
    public void testCreateContactContactIdFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901","Eric","Schooler","7858421212","111 First Street");
        });
    }

    // Checks if first name requirements throw an exception
    @Test
    public void testCreateContactFirstFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456","myfirstnameisfartoolong","Schooler","7858421212","111 First Street");
        });
    }

    // Checks if last name requirements throw an exception
    @Test
    public void testCreateContactLastFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456","Eric","mylastnameisfartoolong","7858421212","111 First Street");
        });
    }

    // Checks if address requirements throw an exception
    @Test
    public void testCreateContactAddressFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456","Eric","Schooler","7858421212","111 First Street 111 First Street 111 First Street 111 First Street 111");
        });
    }

    // Checks if phone number is too long
    @Test
    public void testCreateContactPhoneToLongFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456","Eric","Schooler","78584212121","111 First Street");
        });
    }

    // Checks if phone number is too short
    @Test
    public void testCreateContactPhoneToShortFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456","Eric","Schooler","785842121","111 First Street");
        });
    }

    // Checks the getters
    @Test
    public void testGetContactInfoFails() {
        Assertions.assertDoesNotThrow(() -> {
            Contact contact1 = new Contact("123456","Eric","Schooler","7858421212","111 First Street");

            assertEquals("Schooler",contact1.getLast());
            assertEquals("Eric",contact1.getFirst());
            assertEquals("123456",contact1.getContactId());
            assertEquals("7858421212",contact1.getPhone());
            assertEquals("111 First Street",contact1.getAddress());
        });
    }
}