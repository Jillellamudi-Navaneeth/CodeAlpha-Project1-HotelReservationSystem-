
import java.util.*;

class Room {
    int roomNumber;
    String category; // Standard, Deluxe, Suite
    boolean isBooked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}

class HotelSystem {
    List<Room> rooms = new ArrayList<>();

    // Initialize rooms
    public HotelSystem() {
        for (int i = 1; i <= 5; i++) rooms.add(new Room(i, "Standard"));
        for (int i = 6; i <= 8; i++) rooms.add(new Room(i, "Deluxe"));
        for (int i = 9; i <= 10; i++) rooms.add(new Room(i, "Suite"));
    }

    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room r : rooms) {
            if (!r.isBooked) {
                System.out.println("Room " + r.roomNumber + " (" + r.category + ")");
            }
        }
    }

    public void bookRoom(int roomNumber) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && !r.isBooked) {
                r.isBooked = true;
                System.out.println("Room " + roomNumber + " booked successfully.");
                return;
            }
        }
        System.out.println("Room not available or already booked.");
    }

    public void cancelBooking(int roomNumber) {
        for (Room r : rooms) {
            if (r.roomNumber == roomNumber && r.isBooked) {
                r.isBooked = false;
                System.out.println("Room " + roomNumber + " booking cancelled.");
                return;
            }
        }
        System.out.println("Room not found or not booked.");
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HotelSystem hotel = new HotelSystem();

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int bookNum = sc.nextInt();
                    hotel.bookRoom(bookNum);
                    break;
                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelNum = sc.nextInt();
                    hotel.cancelBooking(cancelNum);
                    break;
                case 4:
                    System.out.println(" Exiting system...");
                    return;
                default:
                    System.out.println(" Invalid choice.");
            }
        }
    }
}