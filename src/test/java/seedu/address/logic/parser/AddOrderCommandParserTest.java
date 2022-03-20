package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.DETAILS_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ADDRESS_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DETAILS_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.PHONE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DETAILS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalOrders.AMY;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddOrderCommand;
import seedu.address.model.order.Order;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.testutil.OrderBuilder;


public class AddOrderCommandParserTest {
    private AddOrderCommandParser parser = new AddOrderCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Order expectedOrder = new OrderBuilder(AMY).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_AMY + PHONE_DESC_AMY
                + ADDRESS_DESC_AMY + DETAILS_DESC_AMY, new AddOrderCommand(expectedOrder));

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_BOB + NAME_DESC_AMY + PHONE_DESC_AMY
                + ADDRESS_DESC_AMY + DETAILS_DESC_AMY, new AddOrderCommand(expectedOrder));

        // multiple phones - last phone accepted
        assertParseSuccess(parser, NAME_DESC_AMY + PHONE_DESC_BOB + PHONE_DESC_AMY
                + ADDRESS_DESC_AMY + DETAILS_DESC_AMY, new AddOrderCommand(expectedOrder));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, NAME_DESC_AMY + PHONE_DESC_AMY + ADDRESS_DESC_BOB
                + ADDRESS_DESC_AMY + DETAILS_DESC_AMY, new AddOrderCommand(expectedOrder));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddOrderCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_AMY + PHONE_DESC_AMY + ADDRESS_DESC_AMY + DETAILS_DESC_AMY,
                expectedMessage);

        // missing phone prefix
        assertParseFailure(parser, NAME_DESC_AMY + VALID_PHONE_AMY + ADDRESS_DESC_AMY + DETAILS_DESC_AMY,
                expectedMessage);

        // missing address prefix
        assertParseFailure(parser, NAME_DESC_AMY + PHONE_DESC_AMY + VALID_ADDRESS_AMY + DETAILS_DESC_AMY,
                expectedMessage);

        // missing details prefix
        assertParseFailure(parser, NAME_DESC_AMY + PHONE_DESC_AMY + ADDRESS_DESC_AMY + VALID_DETAILS_AMY,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_AMY + VALID_PHONE_AMY + VALID_ADDRESS_AMY + VALID_DETAILS_AMY,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + PHONE_DESC_AMY + ADDRESS_DESC_AMY
                + DETAILS_DESC_AMY, Name.MESSAGE_CONSTRAINTS);

        // invalid phone
        assertParseFailure(parser, NAME_DESC_AMY + INVALID_PHONE_DESC + ADDRESS_DESC_AMY
                + DETAILS_DESC_AMY, Phone.MESSAGE_CONSTRAINTS);

        // invalid address
        assertParseFailure(parser, NAME_DESC_AMY + PHONE_DESC_AMY + INVALID_ADDRESS_DESC
                + DETAILS_DESC_AMY, Address.MESSAGE_CONSTRAINTS);

        // two invalid values - only first invalid value
        assertParseFailure(parser, INVALID_NAME_DESC + PHONE_DESC_AMY + ADDRESS_DESC_AMY
                + INVALID_DETAILS_DESC, Name.MESSAGE_CONSTRAINTS);

        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_AMY + PHONE_DESC_AMY
            + DETAILS_DESC_AMY, String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddOrderCommand.MESSAGE_USAGE));
    }
}
