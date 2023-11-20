// package OasisInfobyte;

import java.util.Scanner;

public class OnlineReservationSystemByRachit{

    private static boolean[] availableSeats = new boolean[10]; 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Seat Availability");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");

            int userOption = sc.nextInt();

            switch (userOption) {

                case 1:
                    displaySeatStatus();
                    break;

                case 2:
                    reserveSelectedSeat();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    System.exit(0); 

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void displaySeatStatus() {
        System.out.println("\nCurrent Seat Status:");
        for (int i = 0; i < availableSeats.length; i++) {
            if (availableSeats[i]) {
                System.out.print("Reserved "); 
            } else {
                System.out.print((i + 1) + " "); 
            }
        }
        System.out.println();
    }

    private static void reserveSelectedSeat() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = inputScanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (availableSeats[seatNumber - 1]) {
            System.out.println("Seat already booked!");
        } else {
            availableSeats[seatNumber - 1] = true; 
            System.out.println("Seat booked!");
        }
    }

    private static void cancelBooking() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = inputScanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!availableSeats[seatNumber - 1]) {
            System.out.println("Seat not booked!");
        } else {
            availableSeats[seatNumber - 1] = false; 
            System.out.println("Booking cancelled!");
        }
    }
}
