package seedu.address.model.order;

import java.util.function.Predicate;

public class OrderBeforeDeliveryDateTimePredicate implements Predicate<Order> {
    private final DeliveryDateTime deliveryDateTime;

    public OrderBeforeDeliveryDateTimePredicate(DeliveryDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    @Override
    public boolean test(Order order) {
        return !order.getComplete().isComplete()
                && order.getDeliveryDateTime().getValue().isBefore(deliveryDateTime.getValue());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof OrderBeforeDeliveryDateTimePredicate // instanceof handles nulls
                && deliveryDateTime.equals(((OrderBeforeDeliveryDateTimePredicate) other).deliveryDateTime));
    }
}
