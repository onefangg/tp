package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ORDERS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.order.Complete;
import seedu.address.model.order.DeliveryDateTime;
import seedu.address.model.order.Details;
import seedu.address.model.order.Order;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;

public class UnmarkOrderCommand extends Command {

    public static final String COMMAND_WORD = "unmarko";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the order identified by the index number used in the displayed order list as incomplete.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_UNMARK_ORDER_SUCCESS = "Order Incomplete: %1$s";

    private final Index targetIndex;

    public UnmarkOrderCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Order> lastShownList = model.getFilteredOrderList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ORDER_DISPLAYED_INDEX);
        }

        Order orderToUnmark = lastShownList.get(targetIndex.getZeroBased());
        Order editedOrder = createUnmarkedOrder(orderToUnmark);

        model.setOrder(orderToUnmark, editedOrder);
        model.updateFilteredOrderList(PREDICATE_SHOW_ALL_ORDERS);
        return new CommandResult(String.format(MESSAGE_UNMARK_ORDER_SUCCESS, editedOrder), true, false);
    }

    /**
     * Creates order that is not completed
     *
     * @param orderToUnmark Order to copy
     * @return Order that is incomplete
     */
    private Order createUnmarkedOrder(Order orderToUnmark) {
        assert orderToUnmark != null;

        Name updatedName = orderToUnmark.getName();
        Phone updatedPhone = orderToUnmark.getPhone();
        Address updatedAddress = orderToUnmark.getAddress();
        Remark updatedRemark = orderToUnmark.getRemark();
        Details updatedDetails = orderToUnmark.getDetails();
        DeliveryDateTime updatedDeliveryDateTime = orderToUnmark.getDeliveryDateTime();
        Complete updatedComplete = new Complete(false);

        return new Order(updatedName, updatedPhone, updatedAddress, updatedRemark, updatedDetails, updatedDeliveryDateTime, updatedComplete);

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UnmarkOrderCommand // instanceof handles nulls
                && targetIndex.equals(((UnmarkOrderCommand) other).targetIndex)); // state check
    }
}
