package seedu.address.testutil;

import seedu.address.logic.commands.EditOrderCommand.EditOrderDescriptor;
import seedu.address.model.order.CollectionType;
import seedu.address.model.order.DeliveryDateTime;
import seedu.address.model.order.Details;
import seedu.address.model.order.Order;
import seedu.address.model.person.Remark;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * A utility class to help with building EditOrderDescriptor objects.
 */
public class EditOrderDescriptorBuilder {

    private EditOrderDescriptor descriptor;

    public EditOrderDescriptorBuilder() {
        descriptor = new EditOrderDescriptor();
    }

    public EditOrderDescriptorBuilder(EditOrderDescriptor descriptor) {
        this.descriptor = new EditOrderDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditOrderDescriptor} with fields containing {@code order}'s details
     */
    public EditOrderDescriptorBuilder(Order order) {
        descriptor = new EditOrderDescriptor();
        descriptor.setDetails(order.getDetails());
        descriptor.setDeliveryDateTime(order.getDeliveryDateTime());
        descriptor.setCollectionType(order.getCollectionType());
        descriptor.setRemark(order.getRemark());
    }


    /**
     * Sets the {@code Details} of the {@code EditOrderDescriptor} that we are building.
     */
    public EditOrderDescriptorBuilder withDetails(String... details) {
        Set<Details> detailsSet = Stream.of(details).map(Details::new).collect(Collectors.toSet());
        descriptor.setDetails(detailsSet);
        return this;
    }

    /**
     * Sets the {@code DeliveryDateTime} of the {@code EditOrderDescriptor} that we are building.
     */
    public EditOrderDescriptorBuilder withDeliveryDateTime(String deliveryDateTime) {
        descriptor.setDeliveryDateTime(new DeliveryDateTime(deliveryDateTime));
        return this;
    }

    /**
     * Sets the {@code CollectionType} of the {@code EditOrderDescriptor} that we are building.
     */
    public EditOrderDescriptorBuilder withCollectionType(CollectionType collectionType) {
        descriptor.setCollectionType(collectionType);
        return this;
    }

    /**
     * Sets the {@code Details} of the {@code EditOrderDescriptor} that we are building.
     */
    public EditOrderDescriptorBuilder withRemark(String remark) {
        descriptor.setRemark(new Remark(remark));
        return this;
    }


    public EditOrderDescriptor build() {
        return descriptor;
    }
}
