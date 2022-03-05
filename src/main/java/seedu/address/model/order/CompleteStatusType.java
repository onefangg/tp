package seedu.address.model.order;

/**
 * Represents an Order's completion status.
 */
public enum CompleteStatusType {
    COMPLETE {
        @Override
        public String toString() {
            return "Completed";
        }
    },
    INCOMPLETE {
        @Override
        public String toString() {
            return "Not Completed";
        }
    },
    INVALID {
        @Override
        public String toString() {
            return "Invalid Status";
        }
    };

    /**
     * Parses String to generate a CompleteStatusType. For compability with custom statuses
     * with JsonAdapted Order.
     *
     * @param value String representation of completeStatus
     * @return CompleteStatusType Matching CompleteStatusType of String value passed
     */
    public static CompleteStatusType convertStringToStatusType(String value) {
        if (value.equals(COMPLETE.toString())) {
            return COMPLETE;
        } else if (value.equals(INCOMPLETE.toString())) {
            return INCOMPLETE;
        }
        return INVALID;
    }
}
