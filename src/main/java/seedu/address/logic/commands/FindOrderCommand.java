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
public class FindOrderCommand extends Command {
    public static final String COMMAND_WORD = "findo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all orders based on attributes (name/phone) "
            + "whose attributes contain any of the specified keywords (case-insensitive)"
            + " and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD (n|p)/ [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + "n/ alice bob charlie";

    private final Predicate<Order> predicate;

    public FindOrderCommand(Predicate<Order> predicate) {
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
}
