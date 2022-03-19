package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.order.Order;

/**
 *  Finds and lists all orders in ReadyBakey whose predicate (attribute) contains any of the argument keywords.
 *  Search orders based on attributes is only current supported by {@code name} and {@code phone}.
 *  Keyword matching is case insensitive.
 */
public class FindOrderPhoneCommand extends FindOrderCommand {

    private final Predicate<Order> predicate;

    public FindOrderPhoneCommand(Predicate<Order> predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredOrderList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_ORDERS_LISTED_OVERVIEW, model.getFilteredOrderList().size()),
                true, false);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindOrderPhoneCommand // instanceof handles nulls
                && predicate.equals(((FindOrderPhoneCommand) other).predicate)); // state check
    }
}
