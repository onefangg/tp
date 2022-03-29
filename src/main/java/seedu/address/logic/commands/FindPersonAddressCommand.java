package seedu.address.logic.commands;

import seedu.address.model.person.AddressContainsKeywordsPredicate;

public class FindPersonAddressCommand extends FindPersonCommand {
    public FindPersonAddressCommand(AddressContainsKeywordsPredicate predicate) {
        super(predicate);
    }
}
