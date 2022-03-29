package seedu.address.logic.commands;

import seedu.address.model.person.PhoneContainsKeywordsPredicate;

public class FindPersonPhoneCommand extends FindPersonCommand {

    public FindPersonPhoneCommand(PhoneContainsKeywordsPredicate predicate) {
        super(predicate);
    }

}
