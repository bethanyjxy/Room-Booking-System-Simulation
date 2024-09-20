# Room Booking System

## Overview
This is a basic Java-based room booking system implemented with Object-Oriented Programming (OOP) principles. It allows students and teachers to manage room bookings with features such as promo codes, room availability, and detailed booking information.

## Instructions

### Login Information

#### Student Login:
- **Username:** `stud` followed by any numbers (e.g., stud123)
- **Password:** `12345`

#### Teacher Login:
- **Username:** `staf` followed by any numbers (e.g., staf456)
- **Password:** `54321`

### Time Format
- **From** and **Till** times are in the 24-hour clock format.
- **Yes** and **No** inputs for availability are not case-sensitive.
- 
### Teacher Menu
- **Option 7:** Import sample data for promo codes and rooms for testing other features.
- **Option 1:** Create rooms. You can repeat this process multiple times to create additional rooms.
- You can:
  - Change room availability (Yes/No).
  - Edit room details such as price, time, and capacity.
  - Edit, view, and delete promo codes.

### Student Menu
- **Random Student Names:** When logging in, a random student name will be assigned to you. This changes if you log out and log in again.
- If a promo code is available, it will be displayed at the top of the screen. You can apply it when booking a room.

#### Booking Features:
1. **View Available Rooms:** Only rooms marked as "available" are shown.
2. **Create Booking:**
   - Choose a room and enter the booking time. The time must be within the room's available time (From/Till).
   - If you exceed the available time, you will be prompted to re-enter the time.
   - Option to enter a promo code. If the promo is invalid or doesn't meet the minimum spend requirement, you'll see a message.
   - The payment page will show the hours booked, total price, any discounts, and the final price after applying the promo code.
   - Confirm the booking, and a booking ID will be generated. The room will no longer appear in the available rooms list.
3. **View Bookings:** Displays your current bookings in a table.
4. **Modify Booking:**
   - Enter your booking ID to change the time and hours.
   - The new price and time slot will be calculated, and you may need to pay extra or receive a refund.
5. **Cancel Booking:**
   - Enter your booking ID to cancel the booking.
   - After confirming the cancellation, the room will be available again in the available rooms list.


## Future Improvements
- Adding a feature to view booked rooms along with the student names.
- Enhancing the user interface and adding more room management options.

## How to Run
1. Compile all the Java files.
2. Run the `RBS` main class to start the application.
3. Follow the instructions for logging in and using the system.
