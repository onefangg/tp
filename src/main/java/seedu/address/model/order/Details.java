package seedu.address.model.order;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an order's details in ReadyBakey.
 * Guarantees: immutable; is valid as declared in {@link #isValidDetails(String)}
 */
public class Details {
    /*
     * Details passed in should follow convention eg. "1 : chocolate cake with sprinkles".
     * Characters preceding the colon should only be numerical. This is parsed as the quantity.
     * Characters following the colon should be either alphabets or whitespace. This is parsed as the order item.
     */
    private static final String ORDER_QUANTITY_REGEX_KEYWORD = "orderQuantity";
    private static final String ORDER_ITEM_REGEX_KEYWORD = "orderItem";
    private static final String VALIDATION_REGEX = String.format("^(\\s+)?(?<%s>\\d+)\\s*:{1}\\s*(?<%s>((\\w|\\w )+))(\\s+)?$",
        ORDER_QUANTITY_REGEX_KEYWORD, ORDER_ITEM_REGEX_KEYWORD);
    public static final Pattern DETAIL_PATTERN = Pattern.compile(VALIDATION_REGEX);

    public static final String MESSAGE_CONSTRAINTS = "Details consists of a number (quantity), " +
            "followed by a colon (:) and by alphabetical or whitespace characters. \n EXAMPLE: d/1: vanilla cake";

    public final String value;
    public final String item;
    public final int quantity;

    /**
     * Constructs an {@code Details}.
     *
     * @param details A valid details.
     */
    public Details(String details) {
        requireNonNull(details);
        checkArgument(isValidDetails(details), MESSAGE_CONSTRAINTS);
        value = details;
        quantity = parseValidatedQuantity();
        item = parseValidatedItem();
    }

    /**
     * Returns true if a given string is a valid detail.
     */
    public static boolean isValidDetails(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    private int parseValidatedQuantity() {
        String quantityParsed = parseDetails(ORDER_QUANTITY_REGEX_KEYWORD);
        assert quantityParsed != null;
        return Integer.parseInt(quantityParsed);
    }

    private String parseValidatedItem() {
        String itemParsed = parseDetails(ORDER_ITEM_REGEX_KEYWORD);
        assert itemParsed != null;
        return itemParsed;
    }

    private String parseDetails(String regexKeyword) {
        assert regexKeyword.equals(ORDER_QUANTITY_REGEX_KEYWORD) || regexKeyword.equals(ORDER_ITEM_REGEX_KEYWORD);
        assert isValidDetails(value);

        final Matcher matcher = DETAIL_PATTERN.matcher(value);

        if (!matcher.matches()) {
            return null;
        }
        return matcher.group(regexKeyword);
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
