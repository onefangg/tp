package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.order.OrderPhoneContainsKeywordsPredicate;
import seedu.address.model.person.Person;

/**
 *  Finds and lists all orders in ReadyBakey whose predicate (attribute) contains any of the argument keywords.
 *  Search orders based on attributes is only current supported by {@code name} and {@code phone}.
 *  Keyword matching is case insensitive.
 */
public class FindOrderNameCommand extends FindOrderCommand {

    private final Predicate<Person> predicate;

    public FindOrderNameCommand(Predicate<Person> predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        List<Person> filteredList = model.getFilteredPersonList().filtered(predicate);
        String[] phoneKeywords = filteredList.stream().map(person->person.getPhone().value).toArray(String[]::new);
        model.updateFilteredOrderList(new OrderPhoneContainsKeywordsPredicate(Arrays.asList(phoneKeywords)));
        return new CommandResult(
                String.format(Messages.MESSAGE_ORDERS_LISTED_OVERVIEW, model.getFilteredOrderList().size()),
                true, false);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindOrderNameCommand // instanceof handles nulls
                && predicate.equals(((FindOrderNameCommand) other).predicate)); // state check
    }
}
