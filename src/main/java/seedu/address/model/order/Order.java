package seedu.address.model.order;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;

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
    private final Remark remark;
    private final Details details;
    private final DeliveryDateTime deliveryDateTime;
    private final Complete complete;

    /**
     * Every field must be present and not null.
     */
    public Order(Name name, Phone phone, Address address, Remark remark, Details details, DeliveryDateTime deliveryDateTime) {
        requireAllNonNull(name, phone, address, remark, details, deliveryDateTime);
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.remark = remark;
        this.details = details;
        this.complete = new Complete(false);
        this.deliveryDateTime = deliveryDateTime;
    }

    /**
     * Every field must be present and not null.
     */
    public Order(Name name, Phone phone, Address address, Remark remark, Details details, DeliveryDateTime deliveryDateTime, Complete complete) {
        requireAllNonNull(name, phone, address, remark, details, deliveryDateTime, complete);
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.remark = remark;
        this.details = details;
        this.deliveryDateTime = deliveryDateTime;
        this.complete = complete;
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

    public Remark getRemark() {
        return remark;
    }

    public DeliveryDateTime getDeliveryDateTime() { return deliveryDateTime; }

    public Complete getComplete() {
        return complete;
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
                && otherOrder.getRemark().equals(getRemark())
                && otherOrder.getDetails().equals(getDetails())
                && otherOrder.getDeliveryDateTime().equals(getDeliveryDateTime())
                ;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, address, remark, details, deliveryDateTime);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Address: ")
                .append(getAddress())
                .append("; Remark: ")
                .append(getRemark())
                .append("; Details: ")
                .append(getDetails())
                .append("; Delivery Date: ")
                .append(getDeliveryDateTime())
                .append("; Complete: ")
                .append(getComplete());

        return builder.toString();
    }

}
