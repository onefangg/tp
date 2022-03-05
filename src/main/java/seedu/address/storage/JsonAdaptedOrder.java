package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.order.CompleteStatus;
import seedu.address.model.order.CompleteStatusType;
import seedu.address.model.order.Details;
import seedu.address.model.order.Order;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;

/**
 * Jackson-friendly version of {@link Order}.
 */
class JsonAdaptedOrder {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Order's %s field is missing!";

    private final String name;
    private final String phone;
    private final String address;
    private final String details;
    private final String completeStatus;

    /**
     * Constructs a {@code JsonAdaptedOrder} with the given order details.
     */
    @JsonCreator
    public JsonAdaptedOrder(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                             @JsonProperty("address") String address, @JsonProperty("details") String details,
                             @JsonProperty("completeStatus") String completeStatus) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.details = details;
        this.completeStatus = completeStatus;
    }

    /**
     * Converts a given {@code Order} into this class for Jackson use.
     */
    public JsonAdaptedOrder(Order source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        address = source.getAddress().value;
        details = source.getDetails().value;
        completeStatus = source.getCompleteStatus().value;

    }

    /**
     * Converts this Jackson-friendly adapted order object into the model's {@code Order} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted order.
     */
    public Order toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        if (details == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Details.class.getSimpleName()));
        }
        if (!Details.isValidDetails(details)) {
            throw new IllegalValueException(Details.MESSAGE_CONSTRAINTS);
        }
        final Details modelDetails = new Details(details);

        if (!CompleteStatus.isValidCompleteStatus(completeStatus)) {
            throw new IllegalValueException(CompleteStatus.MESSAGE_CONSTRAINTS);
        }
        final CompleteStatus modelCompleteStatus =
                new CompleteStatus(CompleteStatusType.convertStringToStatusType(completeStatus));

        return new Order(modelName, modelPhone, modelAddress, modelDetails, modelCompleteStatus);
    }

}
