package seedu.address.model.order;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class CollectionTypeContainsKeywordsPredicate implements Predicate<Order> {
    private final String keyword;

    public CollectionTypeContainsKeywordsPredicate(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean test(Order order) {
        return order.getCollectionType().getValue().equalsIgnoreCase(keyword);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CollectionTypeContainsKeywordsPredicate // instanceof handles nulls
                && keyword.equals(((CollectionTypeContainsKeywordsPredicate) other).keyword)); // state check
    }
}
