package seedu.address.model.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DETAILS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.testutil.TypicalOrders.EMILY;
import static seedu.address.testutil.TypicalOrders.SIMON;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.OrderBuilder;

public class OrderTest {

    @Test
    public void isSameOrder() {
        // same object -> returns true
        assertTrue(EMILY.isSameOrder(EMILY));

        // null -> returns false
        assertFalse(EMILY.isSameOrder(null));
        assertFalse(EMILY.isSameOrder(SIMON));

        // same phone number, all other attributes different -> returns true
        Order editedEmily = new OrderBuilder(EMILY).withName(VALID_NAME_BOB)
                .withAddress(VALID_ADDRESS_BOB)
                .withDetails(VALID_DETAILS_BOB).build();
        assertTrue(EMILY.isSameOrder(editedEmily));

        // different phone number, all other attributes same -> returns false
        editedEmily = new OrderBuilder(EMILY).withPhone(VALID_PHONE_BOB).build();
        assertFalse(EMILY.isSameOrder(editedEmily));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Order emilyCopy = new OrderBuilder(EMILY).build();
        assertTrue(EMILY.equals(emilyCopy));

        // same object -> returns true
        assertTrue(EMILY.equals(EMILY));

        // null -> returns false
        assertFalse(EMILY.equals(null));

        // different type -> returns false
        assertFalse(EMILY.equals(5));

        // different order -> returns false
        assertFalse(EMILY.equals(SIMON));

        // different name -> returns false
        Order editedEmily = new OrderBuilder(EMILY).withName(VALID_NAME_BOB).build();
        assertFalse(EMILY.equals(editedEmily));

        // different address -> returns false
        editedEmily = new OrderBuilder(EMILY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(EMILY.equals(editedEmily));

        // different phone -> returns false
        editedEmily = new OrderBuilder(EMILY).withPhone(VALID_PHONE_BOB).build();
        assertFalse(EMILY.equals(editedEmily));

        // different details -> returns false
        editedEmily = new OrderBuilder(EMILY).withDetails(VALID_DETAILS_BOB).build();
        assertFalse(EMILY.equals(editedEmily));
    }
}