// Getter and setter class
public class Contact {
    private String contactID;
    private boolean contactIdSet = false;

    // Declares variables for each part of contacts
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Primary constructor for Contact
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {

        // Validates that input is not null and number of characters
        setContactId(contactID);
        setFirst(firstName);
        setLast(lastName);
        setPhone(phone);
        setAddress(address);
    }

    // Get the contact ID
    public String getContactId() {
        return contactID;
    }

    // Set the contact ID
    public void setContactId(String contactID) {

        // Check that the contact ID hasn't been used yet
        if (contactIdSet) {
            throw new UnsupportedOperationException("Contact ID cannot be updated once set");
        }

        // Checks that the contact ID is not null
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be null and must be 10 characters long");
        }
        // Sets after verification
        this.contactID = contactID;
        this.contactIdSet = true;
    }

    // Gets first name
    public String getFirst() {
        return firstName;
    }

    // Sets first name if it meets requirements
    public void setFirst(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must be between 1 and 10 characters");
        }
        this.firstName = firstName;
    }

    // Gets the last name
    public String getLast() {
        return lastName;
    }

    // Sets last name if it meets requirements
    public void setLast(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must be between 1 and 10 characters");
        }
        this.lastName = lastName;
    }

    // Gets phone number
    public String getPhone() {
        return phone;
    }

    // Sets phone number if it meets requirements
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 characters (Do not include country code)");
        }
        this.phone = phone;
    }

    // Gets the address
    public String getAddress() {
        return address;
    }

    // Sets the address if it meets the requirements
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be between 1 and 30 characters");
        }
        this.address = address;
    }
}