# CinemaBookingSystem

A back-end for a cinema booking system.
All input is given through a text file. 

Below is a sample input: 

Cinema 1 A 15  # Row A of cinema 1 has 15 seats
Cinema 1 B 20  # Row B of cinema 1 has 20 seats
Cinema 2 B 5   # Row B of cinema 2 has 5 seats
Cinema 2 X 5   # Row X of cinema 2 has 5 seats
Session 1 09:00 Toy Story    # Toy Story is showing at the 9:00am session in cinema 1
Session 1 14:30 Ratatouille  # Ratatouille is showing at 2:30pm session in cinema 1
Session 2 09:00 Up           # Up is showing at the 9:00am session in cinema 2
Request 1 1 09:00 10 # Request 1 is for 10 tickets for the 9:00am session in cinema 1
                     # Assign seats 1-10 of row A
                     # Output Booking 1 A1-A10
# Test if there are not sufficient seats in the first row, seats will be allocated from the second row
Request 2 1 09:00 12 # Request 2 is for 12 tickets for the 9:00am session in cinema 1
                     # Assign seats 1-12 of row B
                     # Output Booking 2 B1-B12
# Test that bookings are rejected if there are no available seats
Request 3 1 09:00 10 # Request 3 is for 10 tickets for the 9:00am session in cinema 1
                     # Assign no seats
                     # Output Booking rejected
Request 4 1 14:30 10 # Request 4 is for 10 tickets for the 2:30pm session in cinema 1
                     # Assign seats 1-10 of row A
                     # Output Booking 4 A1-A10
# Test that multiple bookings can share a row
Request 5 1 14:30 4  # Request 5 is for 4 tickets for the 2:30pm showing in cinema 1
                     # Assign seats 11-14 of row A
                     # Output Booking 5 A11-A14
Request 6 2 09:00 3  # Request 6 is for 3 tickets for the 9:00am session in cinema 2
                     # Assign seats 1-3 of row B
                     # Output Booking 6 B1-B3
Change 1 1 14:30 7   # Change booking 1 to 7 tickets for the 2:30pm session in cinema 1
                     # Assign seats 1-7 of row B
                     # Output Change 1 B1-B7
Cancel 6             # Cancel booking 6
                     # Deassign seats 1-3 of row B for the 9:00am session in cinema 2
                     # Output Cancel 6
Print 1 14:30        # Print the bookings for the 2:30pm session in cinema 1
                     # Print the title of the film showing in that session followed by the bookings in each row
                     # Rows are printed in the order they are declared in the input, one line for each row
                     # Print the row name, ':' and the seat ranges booked (in seat order), separated by commas
                     # Rows with no bookings are not printed out at all
