package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DETAILS_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PHONE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
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
import seedu.address.model.order.Details;
import seedu.address.model.order.Order;
import seedu.address.model.person.Phone;
import seedu.address.testutil.OrderBuilder;


public class AddOrderCommandParserTest {
    private AddOrderCommandParser parser = new AddOrderCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Order expectedOrder = new OrderBuilder(AMY).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + PHONE_DESC_AMY
                + DETAILS_DESC_AMY, new AddOrderCommand(new Details(VALID_DETAILS_AMY), new Phone(VALID_PHONE_AMY)));

        // multiple phones - last phone accepted
        assertParseSuccess(parser, PHONE_DESC_BOB + PHONE_DESC_AMY
                 + DETAILS_DESC_AMY, new AddOrderCommand(new Details(VALID_DETAILS_AMY), new Phone(VALID_PHONE_AMY)));


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

        // invalid phone
        assertParseFailure(parser, INVALID_PHONE_DESC
                + DETAILS_DESC_AMY, Phone.MESSAGE_CONSTRAINTS);


        assertParseFailure(parser, PREAMBLE_NON_EMPTY + PHONE_DESC_AMY
            + DETAILS_DESC_AMY, String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddOrderCommand.MESSAGE_USAGE));
    }
}
