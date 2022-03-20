package seedu.address.model.order;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Order}'s {@code Phone} matches any of the keywords given.
 */
public class OrderPhoneContainsKeywordsPredicate implements Predicate<Order> {
    private final List<String> keywords;

    public OrderPhoneContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Order order) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(order.getPhone().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof OrderPhoneContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((OrderPhoneContainsKeywordsPredicate) other).keywords)); // state check
    }
}