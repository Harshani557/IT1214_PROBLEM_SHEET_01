class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String toString() {
        return "Ticket #" + ticketNumber + ", Name: " + customerName + ", Seat: " + seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets;
    private final int MAX_SEATS = 10;

    public BookingSystem() {
        tickets = new Ticket[MAX_SEATS]; 
    }

    public boolean bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > MAX_SEATS) {
            System.out.println("Invalid seat number.");
            return false;
        }
        if (tickets[seatNumber - 1] != null) {
            System.out.println("Seat already booked.");
            return false;
        }
        tickets[seatNumber - 1] = new Ticket(ticketNumber, customerName, seatNumber);
        return true;
    }

    public boolean cancelTicket(int ticketNumber) {
        for (int i = 0; i < MAX_SEATS; i++) {
            if (tickets[i] != null && tickets[i].getTicketNumber() == ticketNumber) {
                tickets[i] = null;
                return true;
            }
        }
        System.out.println("Ticket number not found.");
        return false;
    }

    public void displayBookings() {
        System.out.println("Current Bookings:");
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                System.out.println(ticket);
            }
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Charlie", 3);

        system.cancelTicket(2);

        system.bookTicket(4, "David", 2); 

        system.displayBookings();
    }
}