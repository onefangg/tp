package seedu.address.model.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;

/**
 * Represents an Order in the ReadyBakey.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Order {

    // Identity fields
    private final Name name;
    private final Phone phone;

    // Data fields
    private final Address address;
    private final Details details;

    /**
     * Every field must be present and not null.
     */
    public Order(Name name, Phone phone, Address address, Details details) {
        requireAllNonNull(name, phone, address, details);
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.details = details;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Details getDetails() {
        return details;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns true if both orders have the same phone number.
     * This defines a weaker notion of equality between two orders.
     */
    public boolean isSameOrder(Order otherOrder) {
        if (otherOrder == this) {
            return true;
        }

        return otherOrder != null
                && otherOrder.getPhone().equals(getPhone());
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
        return otherOrder.getName().equals(getName())
                && otherOrder.getPhone().equals(getPhone())
                && otherOrder.getAddress().equals(getAddress())
                && otherOrder.getDetails().equals(getDetails());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, address, details);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Address: ")
                .append(getAddress())
                .append("; Details: ")
                .append(getDetails());

        return builder.toString();
    }

}
