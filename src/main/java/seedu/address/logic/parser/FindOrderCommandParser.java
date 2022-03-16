package seedu.address.logic.parser;

import seedu.address.logic.commands.FindOrderCommand;
import seedu.address.logic.commands.FindPersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.order.OrderContainsKeywordsPredicate;

import java.util.Arrays;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class FindOrderCommandParser implements Parser<FindOrderCommand> {

    public FindOrderCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindPersonCommand.MESSAGE_USAGE));
        }
        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindOrderCommand(new OrderContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
