import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    void testValidContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }


    //Error handling for invalid operations
    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "John", "Doe", "1234567890", "123 Main St"));

        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St"));

        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", null, "1234567890", "123 Main St"));

        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main St"));

        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main St"));
    }

    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "1234567890", null));

        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "1234567890",
                    "123 Main st too long to be valid"));
    }
}

