package seedu.address.model.order;

import static java.util.Objects.requireNonNull;

public class Complete {
    public static final String MESSAGE_CONSTRAINTS = "Complete can take only boolean values";

    public final Boolean value;

    /**
     * Constructs a {@code Complete}.
     *
     * @param value A valid boolean.
     */
    public Complete(Boolean value) {
        requireNonNull(value);

        this.value = value;
    }


    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Complete // instanceof handles nulls
                && value.equals(((Complete) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
