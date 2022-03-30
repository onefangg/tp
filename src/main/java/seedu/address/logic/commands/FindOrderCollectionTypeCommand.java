package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COLLECTION_TYPE;

import java.util.function.Predicate;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.order.Order;

/**
 *  Finds and lists all orders in ReadyBakey whose predicate (Collection Type) contains any of the argument keywords.
 *  Keyword matching is case insensitive.
 */
public class FindOrderCollectionTypeCommand extends FindOrderCommand {

    public static final String MESSAGE_USAGE = COMMAND_WORD + " " + PREFIX_COLLECTION_TYPE
            + "[Keyword]: Finds all orders based on CollectionType attribute \n"
            + "[Keyword] can only be delivery or pickup (case-insensitive)"
            + "Example: " + COMMAND_WORD + PREFIX_COLLECTION_TYPE + "delivery";

    private final Predicate<Order> predicate;

    public FindOrderCollectionTypeCommand(Predicate<Order> predicate) {
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
                || (other instanceof FindOrderCollectionTypeCommand // instanceof handles nulls
                && predicate.equals(((FindOrderCollectionTypeCommand) other).predicate)); // state check
    }
}
