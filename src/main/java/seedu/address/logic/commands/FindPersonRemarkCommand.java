package seedu.address.logic.commands;

import seedu.address.model.person.RemarkContainsKeywordsPredicate;

public class FindPersonRemarkCommand extends FindPersonCommand {
    public FindPersonRemarkCommand(RemarkContainsKeywordsPredicate predicate) {
        super(predicate);
    }
}
