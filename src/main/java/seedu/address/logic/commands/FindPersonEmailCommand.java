package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.EmailContainsKeywordsPredicate;

import static java.util.Objects.requireNonNull;

public class FindPersonEmailCommand extends FindPersonCommand {
    private EmailContainsKeywordsPredicate predicate;
    private final String attributeName = "email";

    public FindPersonEmailCommand(EmailContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_FIND_PERSONS_OVERVIEW, model.getFilteredPersonList().size(),
                        attributeName, predicate.getKeywordsString()),
                false, true);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindPersonEmailCommand // instanceof handles nulls
                && predicate.equals(((FindPersonEmailCommand) other).predicate)); // state check
    }
}
