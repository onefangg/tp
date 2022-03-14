package seedu.remark.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import seedu.address.model.person.Remark;

public class RemarkTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Remark(null));
    }

    @Test
    public void isValidRemark() {
        // null remark
        assertThrows(NullPointerException.class, () -> Remark.isValidRemark(null));

        // valid remarkes
        assertTrue(Remark.isValidRemark("Blk 456, Den Road, #01-355"));
        assertTrue(Remark.isValidRemark("-")); // one character
        assertTrue(Remark.isValidRemark("")); // empty remark
        assertTrue(Remark.isValidRemark("Leng Inc; 1234 Market St; San Francisco CA 2349879; USA")); // long remark
    }
}
