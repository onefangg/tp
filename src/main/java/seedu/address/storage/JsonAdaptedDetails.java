package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.order.Details;

public class JsonAdaptedDetails {
    private final String detailsName;

    @JsonCreator
    public JsonAdaptedDetails(String detailsName) {
        this.detailsName = detailsName;
    }

    public JsonAdaptedDetails(Details source) {
        detailsName = source.value;
    }

    @JsonValue
    public String getDetailsName() {
        return detailsName;
    }

    public Details toModelType() throws IllegalValueException {
        if (!Details.isValidDetails(detailsName)) {
            throw new IllegalValueException(Details.MESSAGE_CONSTRAINTS);
        }
        return new Details(detailsName);
    }
}
