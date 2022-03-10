package seedu.address.model.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an order's details in ReadyBakey.
 * Guarantees: immutable; is valid as declared in {@link #isValidDetails(String)}
 */
public class Details {

    public static final String MESSAGE_CONSTRAINTS = "Details can take any values, and it should not be blank";

    /*
     * The first character of the details must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String value;

    /**
     * Constructs an {@code Details}.
     *
     * @param details A valid details.
     */
    public Details(String details) {
        requireNonNull(details);
        checkArgument(isValidDetails(details), MESSAGE_CONSTRAINTS);
        value = details;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidDetails(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Details // instanceof handles nulls
                && value.equals(((Details) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
