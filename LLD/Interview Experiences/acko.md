**- Machine Coding round:**

**Playground Turf Booking System**
**Problem Statement:**
Your task is to develop a robust playground turf booking system. This system is designed to streamline the process of reserving turf slots for both owners and users alike.

**System Functionalities:**

**For Turf Owners:**

- Turf owners should be able to add new turfs to the system. You can assume a 2 hour slot window starting from 10AM to 10PM.

- Owners should have access to a comprehensive view of bookings made for their turfs.

**For Users:**

- Users should have the ability to book available slots within the playground turfs. Trying to book unavailable slots should throw an error.

- Furthermore, users should have visibility into their past and upcoming bookings.

- They should be granted the flexibility to cancel their bookings.(Extension)

**Input:**

TURF_OWNER ADD turf_hsr

TURF_OWNER LIST_BOOKINGS turf_hsr


USER NEW raghav

USER raghav LIST_AVAILABLE_SLOTS <date>

USER raghav BOOK <slot_id>

USER raghav CANCEL <booking_id>

USER raghav LIST_BOOKINGS

**Implementation Requirements:**

In crafting your solution, adhere to the following guidelines:

- Your solution should implement the above functionalities.

- You have the flexibility to choose suitable representations for the objects involved and the provided use cases. 

- Utilize in-memory data structures exclusively; database usage is strictly prohibited.

- Avoid reliance on external libraries beyond the standard ones bundled with the language runtime.

- The focus should be on functionality; there's no requirement for a fully-fledged web service or exposed APIs.

- Ensure your solution is operational; partial functionality is preferable to non-functioning code.

- During code review, be prepared to demonstrate the functionality of your solution. Ensure that your implementation allows for demonstration of the program's functionality for both turf owners and users.

- Writing comprehensive test cases to validate the correctness of your implementation is strongly encouraged.

