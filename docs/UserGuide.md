
---
layout: page
title: User Guide
---

ReadyBakey is a **desktop app that manages orders and customer contact information, optimized for use via a Command Line Interface**(CLI) while still having the benefits of a Graphical User Interface (GUI). It assists small bakeries by consolidating all the necessary requirements and information for successful order management.

# Table of Contents
1. [Quick Start](#quick-start)
2. [Features](#features)
3. [FAQ](#faq)
4. [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## Quick start <a name="quick-start"></a>

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `readybakey.jar` from [here](https://github.com/AY2122S2-CS2103-F09-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your ReadyBakey.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`listo`** : Lists all orders.

   * **`addp`**`n/John Doe p/87654321 a/21 Kent Ridge Drive` : Adds a customer named `John Doe` to ReadyBakey’s contact list.

   * **`deletep`**`3` : Deletes the 3rd customer from ReadyBakey’s contact list.

   * **`clearp`** : Clears all customers.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features <a name="features"></a>

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `listo`, `exit` and `clearo`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a customer: `addp`

Adds a customer to ReadyBakey’s contact list

Format: `addp n/NAME p/PHONE e/EMAIL a/ADDRESS [t/TAG]`

Examples:
* `addp n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney`

### Delete a customer: `deletep`
Removes a customer from ReadyBakey’s contact list

Format: `deletep INDEX`
* Deletes the customer at the specified INDEX.
* The index refers to the index number shown in the displayed customer list.
* The index must be a positive integer 1, 2, 3, …​
* Only customers with no orders can be deleted.

Examples:
* `deletep 2`


### Listing all customers: `listp`
Shows a list of all customers in ReadyBakey’s contact list

Format: `listp`

Examples:
* `listp`


### Editing a customer's information : `editp`

Edits an existing customer in ReadyBakey's contact list.

Format: `editp INDEX (must be a positive integer) [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [r/REMARK] [t/TAG]`

* Edits the customer at the specified `INDEX`. The index refers to the index number shown in the displayed customer list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `editp 1 p/83456789 e/declan@example.com` Edits the phone number and email address of the 1st customer to be `83456789` and `declan@example.com` respectively.
*  `editp 2 n/Declan` Edits the name of the 2nd customer to be `Declan`.


### Editing an order's information : `edito`

Edits an existing customer in ReadyBakey's contact list.

Format: `edito INDEX [d/DETAILS] [c/DELIVERYDATETIME] [g/COLLECTION_TYPE] [r/REMARKS]`

* Edits the order at the specified `INDEX`. The index refers to the index number shown in the displayed order list. 
  * The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
* `edito 1 d/1: black forest cake` 
  * Edits the details of the 1st order to be `1: black forest cake`.
* `edito 1 d/1: black forest cake d/2: Chocolate Cake` 
  * Edits the details of the 1st order to be `1: black forest 
    cake` and `2: Chocolate Cake`.
    * In this case, to add two details to the order, each `d/` is for one detail.
* `edito 2 r/Two candles` 
  * Edits the 2nd order's remarks to be `Two candles`.
* `edito 2 g/Delivery` 
  * Edits the 2nd order's collection type to be `Delivery`.
* `edito 3 c/Monday 10:30` 
  * Edits the 3rd order's collection time to be `Monday, 04 Apr 2022, 10:30`.
* `edito 3 c/04-04-2022 10:30` 
  * Edits the 3rd order's collection time to be `Monday, 04 Apr 2022, 10:30`.
* `edito 1 d/1: black forest cake d/1: Cheese cake c/04-04-2022 10:30 g/Delivery r/Two candles` 
  * Edits the first order to have order details with `1: black forest cake` and `1: Cheese cake`. 
  * The order delivery date is also now edited to be `Monday, 04 Apr 2022, 10:30`. 
  * Collection type is changed to `Delivery`.
  * Detail remarks is also changed to `Two candles`

### Locating customers by name: `findp`

Finds customer(s) whose name(s) contain any of the given keywords.

Format: `findp KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `gerald` will match `Gerald`
* The order of the keywords does not matter. e.g. `Gerald Tan` will match `Tan Gerald`
* Only the name is searched.
* Only full words will be matched e.g. `Gerald` will not match `Geralds`
* Customers matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Gerald Tan` will return `Gerald Lim`, `Gerald Lee`

Examples:
* `findp John` returns `john` and `John Doe`
* `findp alex david` returns `Alex Yeoh`, `David Li`<br>

### Locating customers by name: `findo`

Finds order(s) whose specific attribute contain any of the given keywords.

Format: `findo [ATTRIBUTE] [KEYWORDS]`

* The supported attributes are `n/`, `p/`, `d/`, `m/`, `r/` 
* The search is case-insensitive. e.g `cake` will match `Cake`
* The order of the keywords does not matter. e.g. `banana cake` will match `cake banana`
* Only the attribute specified is searched.
  * For findo d/[keyword], the keyword should only be the description of the detail and not the quantity
    * Valid Example: findo d/Cake 
    * Invalid Example: findo d/1:Cake
* Only full words will be matched e.g. `Cake` will not match `Cakes`
* Multiple [KEYWORDS] provided will be split up by ` ` and searched individually
  * `findo n/Declan Bob` will search for both `Declan` and `Bob`
* Orders matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Banana Cake` will return `Banana Leaf`, `Strawberry Cake`

Examples:
* `findo n/Declan` returns `declan` and `Declan Lee`
* `findo p/90029382` returns `90029382`
* `findo d/cake` returns `Cake` and `Banana Cake`
* `findo m/delivery` returns `Delivery`
* `findo r/birthday` returns `Birthday` <br>

### Clearing all Customers: `clearp`

Removes all customers stored in ReadyBakey

Format: `clearp`

Examples:
* `clearp`

### Adding an order : `addo`

Adds an order to ReadyBakey’s order list. 

Format: `addo p/PHONE r/REMARK d/DETAILS c/DELIVERYDATETIME m/COLLECTION_TYPE`

Examples:
* `addo p/98765432 r/Add Cheese d/1x Jerry Favourite Cheese Cake c/25-12-2022 15:30 m/Delivery`

### Delete an order: `deleteo`

Removes an order from ReadyBakey

Format: `deleteo INDEX`

* Deletes the order at the specified INDEX
* The index refers to the index number shown in the displayed orders list.
* The index must be a positive integer 1, 2, 3, …​

Examples:
* `deleteo 2`

### Listing all orders: `listo`

Shows a list of all orders in ReadyBakey

Format: `listo`

Examples:
* `listo`

### Listing all orders: `incompleteo`

Shows a list of all incomplete orders in ReadyBakey before and during a given date and time

Format: `incompleteo DELIVERYDATETIME`
* Orders that are incomplete before and during `DELIVERYDATETIME` will be displayed

Examples:
* `incompleteo 25-12-2022 15:30`
* `incompleteo Monday 15:30`

### Mark orders as Complete: `marko`

Marks an order as complete in ReadyBakey

Format: `marko INDEX`

* Marks the order at the specified `INDEX`
* The`INDEX` refers to the index number shown in the displayed orders list.
* The`INDEX` must be a positive integer 1, 2, 3, ...

Examples:
* `marko 1`

### Unmark orders as incomplete: `unmarko`

Unmarks an order as incomplete in ReadyBakey

Format: `unmarko INDEX`

* Unmarks the order at the specified `INDEX`
* The `INDEX` refers to the index number shown in the displayed orders list.
* The `INDEX` must be a positive integer 1, 2, 3, ….

Examples:
* `unmarko 1`

### Clearing all orders : `clearo`
[Feature Coming Soon]

Removes all orders stored in ReadyBakey.

Format: `clearo`

Examples:
* `clearo`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

Examples:
* `exit`

### Saving the data

ReadyBakey data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

ReadyBakey data are saved as a JSON file `[JAR file location]/data/readybakey.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, ReadyBakey will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ <a name="faq"></a>

**Q**: Is an order tied to a specific customer in the customer list?<br>
**A**: Yes, an order is tied to the specific customer as per the customers’ ID.

--------------------------------------------------------------------------------------------------------------------

## Command summary <a name="command-summary"></a>
| Action      | Format                                                                          | Example                                                                                        |
|-------------|---------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| **addp**    | `addp [n/NAME] [p/PHONE\_NUM] [a/ADDRESS] [t/TAG]…​`                         | `addp n/John Doe p/87654321 a/21 Kent Ridge Drive t/colleague t/owesMoney`                     |
| **deletep** | `deletep INDEX`                                                                 | `deletep 2`                                                                                    |
| **listp**   | `listp`                                                                         | `listp`                                                                                        |
| **editp**   | `editp INDEX n/NAME p/PHONE\_NUM a/ADDRESS`                                     | `editp 1 p/12345678 n/John Doey a/NUS`                                                         |
| **findp**   | `findp KEYWORD`                                                                 | `findp John`                                                                                   |
| **clearp**  | `clearp`                                                                        | `clearp`                                                                                       |
| **addo**    | `addo d/DATE\_ORDERED s/DATE\_TO\_SEND c/CUST\_PHONE\_NUM i/ITEM\_ORDERED`      | `addo d/10-10-2022 s/20-10-2022 c/87654321 i/Chocolate Cake`                                   |
| **deleteo** | `deleteo INDEX`                                                                 | `deleteo 2`                                                                                    |
| **listo**   | `listo`                                                                         | `listo`                                                                                        |
| **marko**   | `marko INDEX`                                                                   | `marko 1`                                                                                      |
| **unmarko** | `unmarko INDEX`                                                                 | `unmarko 1`                                                                                    |
| **exit**    | `exit`                                                                          | `exit`                                                                                         |
| **edito**   | `edito INDEX c/DELIVERYDATETIME g/COLLECTION\_TYPE r/REMARKS d/DETAILS…​`    | `edito 1  c/04-04-2022 10:30 g/Delivery r/Two candles d/1: black forest cake d/1: Cheese cake` |

