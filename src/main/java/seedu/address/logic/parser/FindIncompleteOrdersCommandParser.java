package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.function.Predicate;

import seedu.address.logic.commands.FindIncompleteOrdersCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.order.DeliveryDateTime;
import seedu.address.model.order.Order;
import seedu.address.model.order.OrderBeforeDeliveryDateTimePredicate;



public class FindIncompleteOrdersCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the MarkCommand
     * and returns a MarkCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindIncompleteOrdersCommand parse(String args) throws ParseException {
        if (args.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindIncompleteOrdersCommand.MESSAGE_USAGE));
        }
        try {
            Predicate<Order> orderBeforeDeliveryDateTimePredicate;
            DeliveryDateTime deliveryDateTime = ParserUtil.parseDeliveryDateTime(args);
            orderBeforeDeliveryDateTimePredicate = new OrderBeforeDeliveryDateTimePredicate(deliveryDateTime);
            return new FindIncompleteOrdersCommand(orderBeforeDeliveryDateTimePredicate);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindIncompleteOrdersCommand.MESSAGE_USAGE), pe);
        }
    }

}
