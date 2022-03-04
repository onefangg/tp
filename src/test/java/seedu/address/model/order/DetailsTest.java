package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DetailsTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Details(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidDetails = " ";
        assertThrows(IllegalArgumentException.class, () -> new Details(invalidDetails));
    }

    @Test
    public void isValidDetail() {
        // null details
        assertThrows(NullPointerException.class, () -> Details.isValidDetails(null));

        // invalid details
        assertFalse(Details.isValidDetails("")); // empty string
        assertFalse(Details.isValidDetails(" ")); // only whitespace
        assertFalse(Details.isValidDetails("   order")); // whitespace followed by alphanumeric

        // valid details
        assertTrue(Details.isValidDetails("customOrder")); // alphabets only
        assertTrue(Details.isValidDetails("12345")); // numbers only
        assertTrue(Details.isValidDetails("1xchocolatecake")); // alphanumeric characters
        assertTrue(Details.isValidDetails("1xChocolateCake")); // with capital letters
        assertTrue(Details.isValidDetails(
                "chocolate cake with spinkles on top")); // long word with whitespaces in-between
    }

}
