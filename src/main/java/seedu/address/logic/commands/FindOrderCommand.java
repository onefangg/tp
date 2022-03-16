package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.order.OrderContainsKeywordsPredicate;

import static java.util.Objects.requireNonNull;

public class FindOrderCommand extends Command {
    public static final String COMMAND_WORD = "findo";

    private final OrderContainsKeywordsPredicate predicate;

    public FindOrderCommand(OrderContainsKeywordsPredicate predicate) {
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
