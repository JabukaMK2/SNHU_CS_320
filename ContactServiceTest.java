import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    // Checks if duplicate IDs throw an exception
    @Test
    public void testAddContactDuplicateIdFail() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("123457","Eric","Schooler","7858421212","111 First Street");
        Contact contact2 = new Contact("123457","Fin","Jock","7858421211","112 First Street");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // Checks if updating a contact completes successfully
    @Test
    public void testGetContactAndUpdateContactSuccess() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1234","Eric","Schooler","7858421212","111 First Street");

        service.addContact(contact1);

        assertEquals (contact1,service.getContact(contact1.getContactId()));

        service.updateContact("1234","Fin","Jack","7858421211","112 First Street");
        assertEquals (contact1,service.getContact(contact1.getContactId()));
    }

    // Checks if a contact is deleted successfully
    @Test
    public void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1234","Eric","Schooler","7858421212","111 First Street");

        service.addContact(contact1);
        service.deleteContact(contact1.getContactId());
        assertNull(service.getContact(contact1.getContactId()));
    }
}