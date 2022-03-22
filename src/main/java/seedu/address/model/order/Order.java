package seedu.address.model.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.UUID;

import seedu.address.model.person.Phone;

/**
 * Represents an Order in the ReadyBakey.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Order {

    // Identity fields
    private final Phone phone;
    private final UUID uuid;

    // Data fields
    private final Details details;
    private final Complete complete;

    /**
     * Every field must be present and not null.
     */
    public Order(Phone phone, Details details, UUID uuid) {
        requireAllNonNull(phone, details);
        this.phone = phone;
        this.details = details;
        this.complete = new Complete(false);
        this.uuid = uuid;
    }

    /**
     * Every field must be present and not null.
     */
    public Order(Phone phone, Details details, Complete complete, UUID uuid) {
        requireAllNonNull(phone, details, complete);
        this.phone = phone;
        this.details = details;
        this.complete = complete;
        this.uuid = uuid;
    }

    public Phone getPhone() {
        return phone;
    }

    public Details getDetails() {
        return details;
    }

    public Complete getComplete() {
        return complete;
    }

    public UUID getUuid() {
        return uuid;
    }


    /**
     * Returns true if both orders have the same identity and data fields.
     * This defines a stronger notion of equality between two orders.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Order)) {
            return false;
        }

        Order otherOrder = (Order) other;
        return otherOrder.getPhone().equals(getPhone())
                && otherOrder.getDetails().equals(getDetails());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(phone, details, complete);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Phone: ")
                .append(getPhone())
                .append("; Details: ")
                .append(getDetails())
                .append("; Complete: ")
                .append(getComplete());

        return builder.toString();
    }

}
