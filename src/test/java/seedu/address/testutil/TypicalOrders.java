package seedu.address.testutil;

import seedu.address.model.order.Order;

public class TypicalOrders {
    public static final Order EMILY = new OrderBuilder().withName("Emily Lee")
            .withAddress("BLK 123 Ang Mo Kio Ave 4, #05-12")
            .withPhone("94231333")
            .withDetails("1xvanillacake").build();

    public static final Order SIMON = new OrderBuilder().withName("Simon Loo")
            .withAddress("55 Serangoon Avenue 3")
            .withPhone("94241423")
            .withDetails("1xchocolatecake").build();

}
