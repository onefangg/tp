package seedu.address.model.order;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an Orders's deliveryDateTime in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDeliveryDateTime(String)}
 */
public class DeliveryDateTime {

    public static final String MESSAGE_CONSTRAINTS = "DeliveryDateTime should be in the format dd/MM/yyyy HH:mm "
            + "or a natural date (e.g. Mon 22:30, Wednesday 10:20) "
            + "and should be a valid date and time after today's date!";

    /**
     * The first character of the deliveryDateTime must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}";
    public static final DateTimeFormatter PARSER_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public static final DateTimeFormatter STRING_FORMATTER = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy, hh:mm a");

    public final LocalDateTime value;

    /**
     * Constructs an {@code DeliveryDateTime}.
     *
     * @param deliveryDateTime A valid deliveryDateTime.
     */
    public DeliveryDateTime(String deliveryDateTime) {
        requireNonNull(deliveryDateTime);
        checkArgument(isValidDeliveryDateTime(deliveryDateTime), MESSAGE_CONSTRAINTS);
        value = LocalDateTime.parse(deliveryDateTime, PARSER_FORMATTER);
    }

    public static boolean isValidDeliveryDateTimeFormat(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidDeliveryDateTimeValue(String test) {
        try {
            LocalDateTime.parse(test, PARSER_FORMATTER);
        } catch (DateTimeParseException e) {
            return false;
        }
        if (LocalDateTime.parse(test, PARSER_FORMATTER).isBefore(LocalDateTime.now())) {
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
        return value.format(PARSER_FORMATTER);
    }

    @Override
    public String toString() {
        return value.format(STRING_FORMATTER);
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
