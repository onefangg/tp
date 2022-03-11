package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.order.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypicalOrders {
    public static final Order EMILY = new OrderBuilder().withName("Emily Lee")
            .withAddress("BLK 123 Ang Mo Kio Ave 4, #05-12")
            .withPhone("94231333")
            .withDetails("1xvanillacake").build();

    public static final Order SIMON = new OrderBuilder().withName("Simon Loo")
            .withAddress("55 Serangoon Avenue 3")
            .withPhone("94241423")
            .withDetails("1xchocolatecake").build();

    public static final Order JERRY = new OrderBuilder().withName("Jerry Mouse")
            .withAddress("55 Ang Mo Kio Avenue 38")
            .withPhone("91029382")
            .withDetails("1xjerryfavouritecheesecake").build();

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
