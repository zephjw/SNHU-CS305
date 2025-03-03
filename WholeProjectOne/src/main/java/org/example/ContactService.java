import java.util.HashMap;
import java.util.Map;


public class ContactService {


    //HashMap to store contact and easy retrieval using unique ID
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    public void updateContactFirstName(String contactId, String firstName) {
        getContactById(contactId).setFirstName(firstName);
    }

    public void updateContactLastName(String contactId, String lastName) {
        getContactById(contactId).setLastName(lastName);
    }

    public void updateContactPhone(String contactId, String phone) {
        getContactById(contactId).setPhone(phone);
    }

    public void updateContactAddress(String contactId, String address) {
        getContactById(contactId).setAddress(address);
    }

    public Contact getContactById(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        return contact;
    }
}
