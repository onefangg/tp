package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.order.Order;

public class TypicalOrders {
    public static final Order EMILY = new OrderBuilder()
            .withPhone("94231333")
            .withDetails("1xvanillacake")
            .withComplete(false).build();

    public static final Order SIMON = new OrderBuilder()
            .withPhone("94241423")
            .withDetails("1xchocolatecake")
            .withComplete(false).build();

    public static final Order JERRY = new OrderBuilder()
            .withPhone("91029382")
            .withDetails("1xjerryfavouritecheesecake")
            .withComplete(false).build();

    private TypicalOrders() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical orders.
     */
    public static AddressBook getTypicalAddressBookOrders() {
        AddressBook ab = new AddressBook();
        for (Order order : getTypicalOrders()) {
            ab.addOrder(order);
        }
        return ab;
    }

    public static List<Order> getTypicalOrders() {
        return new ArrayList<>(Arrays.asList(EMILY, SIMON, JERRY));
    }
}
