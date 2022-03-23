package seedu.address.storage;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.order.CollectionType;
import seedu.address.model.order.Complete;
import seedu.address.model.order.DeliveryDateTime;
import seedu.address.model.order.Details;
import seedu.address.model.order.Order;
import seedu.address.model.person.Remark;


/**
 * Jackson-friendly version of {@link Order}.
 */
class JsonAdaptedOrder {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Order's %s field is missing!";


    private final String remark;
    private final String details;
    private final String deliveryDateTime;
    private final String collectionType;
    private final String complete;
    private final String uuid;

    /**
     * Constructs a {@code JsonAdaptedOrder} with the given order details.
     */
    @JsonCreator
    public JsonAdaptedOrder(@JsonProperty("remark") String remark,
                            @JsonProperty("details") String details,
                            @JsonProperty("deliveryDateTime") String deliveryDateTime,
                            @JsonProperty("collectionType") String collectionType,
                            @JsonProperty("complete") String complete,
                            @JsonProperty("uuid") String uuid) {
        this.remark = remark;
        this.details = details;
        this.deliveryDateTime = deliveryDateTime;
        this.collectionType = collectionType;
        this.complete = complete;
        this.uuid = uuid;
    }

    /**
     * Converts a given {@code Order} into this class for Jackson use.
     */
    public JsonAdaptedOrder(Order source) {

        remark = source.getRemark().value;
        details = source.getDetails().value;
        deliveryDateTime = source.getDeliveryDateTime().toJsonSavedString();
        collectionType = source.getCollectionType().value;
        complete = source.getComplete().value.toString();
        uuid = source.getUuid().toString();

    }

    /**
     * Converts this Jackson-friendly adapted order object into the model's {@code Order} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted order.
     */
    public Order toModelType() throws IllegalValueException {

        final Remark modelRemark = new Remark(remark);

        if (details == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Details.class.getSimpleName()));
        }
        if (!Details.isValidDetails(details)) {
            throw new IllegalValueException(Details.MESSAGE_CONSTRAINTS);
        }
        final Details modelDetails = new Details(details);

        if (deliveryDateTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    DeliveryDateTime.class.getSimpleName()));
        }
        if (!DeliveryDateTime.isValidDeliveryDateTime(deliveryDateTime)) {
            throw new IllegalValueException(DeliveryDateTime.MESSAGE_CONSTRAINTS);
        }
        final DeliveryDateTime modelDeliveryDateTime = new DeliveryDateTime(deliveryDateTime);

        if (collectionType == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    CollectionType.class.getSimpleName()));
        }
        if (!CollectionType.isValidCollectionTypeValue(collectionType)) {
            throw new IllegalValueException(CollectionType.MESSAGE_CONSTRAINTS);
        }

        final CollectionType modelCollectionType;
        if (collectionType.equals(CollectionType.DELIVERY.getValue())) {
            modelCollectionType = CollectionType.DELIVERY;
        } else if (collectionType.equals(CollectionType.PICKUP.getValue())) {
            modelCollectionType = CollectionType.PICKUP;
        } else {
            throw new IllegalValueException(CollectionType.MESSAGE_CONSTRAINTS);
        }

        if (complete == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Complete.class.getSimpleName())
            );
        }
        if (!Complete.isValidComplete(complete)) {
            throw new IllegalValueException(Complete.MESSAGE_CONSTRAINTS);
        }
        final Complete modelComplete = new Complete(complete);

        final UUID modelUuid;
        try {
            modelUuid = UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new IllegalValueException(Complete.MESSAGE_CONSTRAINTS);
        }

        return new Order(modelRemark, modelDetails, modelDeliveryDateTime,
                modelCollectionType, modelComplete, modelUuid);
    }

}
