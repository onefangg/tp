package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.order.Order;

/**
 *  Finds and lists all orders in ReadyBakey whose predicate (Remark) contains any of the argument keywords.
 *  Keyword matching is case insensitive.
 */
public class FindOrderRemarkCommand extends FindOrderCommand {

    private final Predicate<Order> predicate;

    public FindOrderRemarkCommand(Predicate<Order> predicate) {
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
                || (other instanceof FindOrderRemarkCommand // instanceof handles nulls
                && predicate.equals(((FindOrderRemarkCommand) other).predicate)); // state check
    }
}
