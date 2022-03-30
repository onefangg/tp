package seedu.address.model.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import seedu.address.model.order.NaturalDateParser.Dates;


/**
 * DateChecker is used to help convert Strings into the proper date time formats.
 * It also helps to check for the validity of the date inputted.
 * If the date input is invalid, (e.g. missing the day, short form months), it throws a DukeException.
 */
public class DateChecker {
    private static String dateFormat;
    private static String dateToCheck;

    private static final int NUM_DAYS_IN_WEEK = 7;

    /**
     * Method meant to detect what type of date user inputs.
     * Format inputs that are not valid date types, but are natural dates.
     * Returns the original input if it notices that it is not a natural date.
     */
    private static void naturalDateCheck() {
        // add case to check for time provided
        NaturalDateParser dateChecked = new NaturalDateParser(dateToCheck);
        Dates inputtedDay = dateChecked.getDate(); // This gives the enum date which is like "MONDAY"
        Calendar now = Calendar.getInstance();
        int today = now.get(Calendar.DAY_OF_WEEK);

        int nextMonday = (Calendar.SATURDAY - today + 2) % NUM_DAYS_IN_WEEK;
        int nextTuesday = (Calendar.SATURDAY - today + 3) % NUM_DAYS_IN_WEEK;
        int nextWednesday = (Calendar.SATURDAY - today + 4) % NUM_DAYS_IN_WEEK;
        int nextThursday = (Calendar.SATURDAY - today + 5) % NUM_DAYS_IN_WEEK;
        int nextFriday = (Calendar.SATURDAY - today + 6) % NUM_DAYS_IN_WEEK;
        int nextSaturday = (Calendar.SATURDAY - today) % NUM_DAYS_IN_WEEK;
        int nextSunday = (Calendar.SATURDAY - today + 1) % NUM_DAYS_IN_WEEK;

        boolean isValidDate = true;
        int daysAfter = 0;

        switch (inputtedDay) {
        case MONDAY:
            if (today != Calendar.MONDAY) {
                daysAfter = nextMonday;
            }
            break;
        case TUESDAY:
            if (today != Calendar.TUESDAY) {
                daysAfter = nextTuesday;
            }
            break;
        case WEDNESDAY:
            if (today != Calendar.WEDNESDAY) {
                daysAfter = nextWednesday;
            }
            break;
        case THURSDAY:
            if (today != Calendar.THURSDAY) {
                daysAfter = nextThursday;
            }
            break;
        case FRIDAY:
            if (today != Calendar.FRIDAY) {
                daysAfter = nextFriday;
            }
            break;
        case SATURDAY:
            if (today != Calendar.SATURDAY) {
                daysAfter = nextSaturday;
            }
            break;
        case SUNDAY:
            if (today != Calendar.SUNDAY) {
                daysAfter = nextSunday;
            }
            break;
        default:
            dateFormat = dateToCheck;
            isValidDate = false;
            break;
        }
        if (isValidDate) {
            dateFormat = formatDate(now, daysAfter);
        }
    }

    /**
     * Formats the natural date input with a time as a proper datetime.
     *
     * @param input Input is the date string provided by the user.
     * @return returns a properly formatted date string with the time
     */
    public static String parsePotentialNaturalDate(String input) {
        try {
            String[] inputSplit = input.split("\\s+", 2);
            String date = inputSplit[0];
            String time = inputSplit[1];
            dateToCheck = date;
            naturalDateCheck();
            return dateFormat + " " + time;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            dateToCheck = input;
            return input;
        }
    }

    /**
     * This formats the Date to String. Used in DateChecker only.
     *
     * @param now Calendar class object meant to format the date.
     * @return Date in String format.
     */
    private static String formatDate(Calendar now, int daysAfterToday) {
        now.add(Calendar.DAY_OF_YEAR, daysAfterToday);
        Date date = now.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }
}
