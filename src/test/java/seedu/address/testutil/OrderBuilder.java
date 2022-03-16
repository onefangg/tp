package seedu.address.testutil;

import seedu.address.model.order.Complete;
import seedu.address.model.order.DeliveryDateTime;
import seedu.address.model.order.Details;
import seedu.address.model.order.Order;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;

public class OrderBuilder {
    public static final String DEFAULT_NAME = "Tom";
    public static final String DEFAULT_PHONE = "11111111";
    public static final String DEFAULT_ADDRESS = "Jerry’s House 111111";
    public static final String DEFAULT_DETAILS = "1xchocholatecake";
    public static final String DEFAULT_REMARK = "Add more chocolate";
    public static final String DEFAULT_DELIVERYDATETIME = "10-12-2022 17:00";
    public static final Boolean DEFAULT_COMPLETE = false;

    private Name name;
    private Phone phone;
    private Address address;
    private Remark remark;
    private Details details;
    private DeliveryDateTime deliveryDateTime;
    private Complete complete;

    /**
     * Creates a {@code OrderBuilder} with the default details.
     */
    public OrderBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        address = new Address(DEFAULT_ADDRESS);
        remark = new Remark(DEFAULT_REMARK);
        details = new Details(DEFAULT_DETAILS);
        deliveryDateTime = new DeliveryDateTime(DEFAULT_DELIVERYDATETIME);
        complete = new Complete(DEFAULT_COMPLETE);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public OrderBuilder(Order orderToCopy) {
        name = orderToCopy.getName();
        phone = orderToCopy.getPhone();
        address = orderToCopy.getAddress();
        remark = orderToCopy.getRemark();
        details = orderToCopy.getDetails();
        deliveryDateTime = orderToCopy.getDeliveryDateTime();
        complete = orderToCopy.getComplete();
    }

    /**
     * Sets the {@code Name} of the {@code Order} that we are building.
     */
    public OrderBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Order} that we are building.
     */
    public OrderBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Order} that we are building.
     */
    public OrderBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Order} that we are building.
     */
    public OrderBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    /**
     * Sets the {@code Details} of the {@code Order} that we are building.
     */
    public OrderBuilder withDetails(String details) {
        this.details = new Details(details);
        return this;
    }

    /**
     * Sets the {@code deliveryDateTime} of the {@code Order} that we are building.
     */
    public OrderBuilder withDeliveryDateTime(String deliveryDateTime) {
        this.deliveryDateTime = new DeliveryDateTime(deliveryDateTime);
        return this;
    }

    /**
     * Sets the {@code Complete} of the {@code Order} that we are building.
     */
    public OrderBuilder withComplete(Boolean complete) {
        this.complete = new Complete(complete);
        return this;
    }

    public Order build() {
        return new Order(name, phone, address, remark, details, deliveryDateTime, complete);
    }
}
