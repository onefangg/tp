package seedu.address.logic.commands;

import seedu.address.model.person.EmailEqualsKeywordsPredicate;

public class FindPersonEmailCommand extends FindPersonCommand {
    public FindPersonEmailCommand(EmailEqualsKeywordsPredicate predicate) {
        super(predicate);
    }
}
