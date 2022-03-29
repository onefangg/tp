package seedu.address.logic.commands;

import seedu.address.model.person.NameContainsKeywordsPredicate;

public class FindPersonNameCommand extends FindPersonCommand {
    public FindPersonNameCommand(NameContainsKeywordsPredicate predicate) {
        super(predicate);
    }

}
