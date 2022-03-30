package seedu.address.logic.commands;

import seedu.address.model.person.EmailContainsKeywordsPredicate;

public class FindPersonEmailCommand extends FindPersonCommand {
    public FindPersonEmailCommand(EmailContainsKeywordsPredicate predicate) {
        super(predicate);
    }
}
