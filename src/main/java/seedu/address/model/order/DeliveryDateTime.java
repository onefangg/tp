package seedu.address.model.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Orders's deliveryDateTime in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDeliveryDateTime(String)}
 */
public class DeliveryDateTime {

    public static final String MESSAGE_CONSTRAINTS = "DeliveryDateTime should be in the format dd/MM/yyyy HH:mm and should be a valid date and time before today's date!";

    /*
     * The first character of the deliveryDateTime must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}";

    public final LocalDateTime value;
    public static final DateTimeFormatter parserFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public static final DateTimeFormatter stringFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy, hh:mm a");

    /**
     * Constructs an {@code DeliveryDateTime}.
     *
     * @param deliveryDateTime A valid deliveryDateTime.
     */
    public DeliveryDateTime(String deliveryDateTime) {
        requireNonNull(deliveryDateTime);
        checkArgument(isValidDeliveryDateTime(deliveryDateTime), MESSAGE_CONSTRAINTS);
        value = LocalDateTime.parse(deliveryDateTime, parserFormatter);
    }

    public static boolean isValidDeliveryDateTimeFormat(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public static boolean isValidDeliveryDateTimeValue(String test) {
        try {
            LocalDateTime.parse(test, parserFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        if (LocalDateTime.parse(test, parserFormatter).isBefore(LocalDateTime.now())) {
            return false;
        }
        return true;
    }

    /**
     * Returns true if a given string is a valid datetime.
     */
    public static boolean isValidDeliveryDateTime(String test) {
        return isValidDeliveryDateTimeFormat(test) && isValidDeliveryDateTimeValue(test);
    }

    public String toJsonSavedString() {
        return value.format(parserFormatter);
    }

    @Override
    public String toString() {
        return value.format(stringFormatter);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeliveryDateTime // instanceof handles nulls
                && value.equals(((DeliveryDateTime) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
