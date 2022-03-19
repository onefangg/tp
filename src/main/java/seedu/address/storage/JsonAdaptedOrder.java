package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.order.Complete;
import seedu.address.model.order.Details;
import seedu.address.model.order.Order;
import seedu.address.model.person.Phone;

/**
 * Jackson-friendly version of {@link Order}.
 */
class JsonAdaptedOrder {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Order's %s field is missing!";

    private final String phone;
    private final String details;
    private final String complete;

    /**
     * Constructs a {@code JsonAdaptedOrder} with the given order details.
     */
    @JsonCreator
    public JsonAdaptedOrder(@JsonProperty("phone") String phone,
                             @JsonProperty("details") String details,
                             @JsonProperty("complete") String complete) {
        this.phone = phone;
        this.details = details;
        this.complete = complete;
    }

    /**
     * Converts a given {@code Order} into this class for Jackson use.
     */
    public JsonAdaptedOrder(Order source) {
        phone = source.getPhone().value;
        details = source.getDetails().value;
        complete = source.getComplete().value.toString();

    }

    /**
     * Converts this Jackson-friendly adapted order object into the model's {@code Order} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted order.
     */
    public Order toModelType() throws IllegalValueException {
        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (details == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Details.class.getSimpleName()));
        }
        if (!Details.isValidDetails(details)) {
            throw new IllegalValueException(Details.MESSAGE_CONSTRAINTS);
        }
        final Details modelDetails = new Details(details);

        if (complete == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Complete.class.getSimpleName())
            );
        }
        if (!Complete.isValidComplete(complete)) {
            throw new IllegalValueException(Complete.MESSAGE_CONSTRAINTS);
        }
        final Complete modelComplete = new Complete(complete);

        return new Order(modelPhone, modelDetails, modelComplete);
    }

}
