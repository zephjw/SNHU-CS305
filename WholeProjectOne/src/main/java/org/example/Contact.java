/*
* John Zephyr
* CS-320
* 2 February 2025
*
* */



public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate all fields
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setters with validation
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Validation methods
    private void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10 || contactId.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact ID must not be null and must be 10 characters or less");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10 || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10 || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30 || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less");
        }
    }
}