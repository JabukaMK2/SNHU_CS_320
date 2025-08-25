import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Declare the hash map for storing contacts
    private Map<String, Contact> contacts = new HashMap<>();

    // Add a contact
    public void addContact(Contact contact) {

        // If contact is null or contact ID is null, throw exception
        if (contact == null || contact.getContactId() == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }

        // If contact ID already exists, throw exception
        else if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact already exists");
        }

        // Else add contact
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact
    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    // Get a contact
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }

    // Update a contact
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = getContact(contactID);
        if (contact != null) {
            contact.setFirst(firstName);
            contact.setLast(lastName);
            contact.setPhone(phone);
            contact.setAddress(address);
        }
    }
}
