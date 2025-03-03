package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact testContact;

    @BeforeEach
    void setUp() {
        contactService = new ContactService ( );
        testContact = new Contact ("1234567890" , "John" , "Doe" , "1234567890" , "123 Main St");
    }


    @Test
    void testAddContact() {
        contactService.addContact(testContact);
        assertEquals(testContact, contactService.getContactById("1234567890"));
    }


    @Test
    void testAddDuplicateContact() {
        contactService.addContact(testContact);
        Contact duplicateContact = new Contact ("1234567890" , "Jane" , "Doe" , "0987654321" , "456 Oak St");
        assertThrows(IllegalArgumentException.class, () -> 
            contactService.addContact(duplicateContact));
    }

    // Confirm deletion of a contact
    @Test
    void testDeleteContact() {
        contactService.addContact(testContact);
        contactService.deleteContact("1234567890");
        assertThrows(IllegalArgumentException.class, () -> 
            contactService.getContactById("1234567890"));
    }

    // test confirming update to first name
    @Test
    void testUpdateContactFirstName() {
        contactService.addContact(testContact);
        contactService.updateContactFirstName("1234567890", "Jane");
        assertEquals("Jane", contactService.getContactById("1234567890").getFirstName());
    }

    // Confirming update to last name
    @Test
    void testUpdateContactLastName() {
        contactService.addContact(testContact);
        contactService.updateContactLastName("1234567890", "Smith");
        assertEquals("Smith", contactService.getContactById("1234567890").getLastName());
    }

    // Confirming update to phone number
    @Test
    void testUpdateContactPhone() {
        contactService.addContact(testContact);
        contactService.updateContactPhone("1234567890", "9876543210");
        assertEquals("9876543210", contactService.getContactById("1234567890").getPhone());
    }

    // Confirming update to address
    @Test
    void testUpdateContactAddress() {
        contactService.addContact(testContact);
        contactService.updateContactAddress("1234567890", "456 Oak St");
        assertEquals("456 Oak St", contactService.getContactById("1234567890").getAddress());
    }

    @Test
    void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> 
            contactService.updateContactFirstName("nonexistent", "Jane"));
    }

    private static class ContactService {
        public void updateContactFirstName (String nonexistent , String jane) {

        }
    }

    private static class Contact {
        private final String number;
        private final String john;

        public Contact (String number , String john , String doe , String number1 , String s) {
            this.number = number;
            this.john = john;
        }
    }
}