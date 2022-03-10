package seedu.address.model.order;

/**
 * Represents an Order's completeStatus in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidCompleteStatus(String)}
 */
public class CompleteStatus {
    public static final String MESSAGE_CONSTRAINTS = "CompleteStatus value can only be as defined in "
            + "CompleteStatusType";

    public final String value;

    /**
     * Constructs a CompleteStatus
     * @param completeStatusType A valid completeStatusType
     */
    public CompleteStatus(CompleteStatusType completeStatusType) {
        value = completeStatusType.toString();
    }


    /**
     * Returns true if a given string is a valid CompleteStatusType.
     */
    public static boolean isValidCompleteStatus(String test) {
        return test.equals(CompleteStatusType.COMPLETE.toString())
                || test.equals(CompleteStatusType.INCOMPLETE.toString());
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CompleteStatus); // instanceof handles nulls
    }
}
