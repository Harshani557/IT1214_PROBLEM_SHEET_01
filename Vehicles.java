class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    // Constructor
    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    // Getters
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    // Display method
    public void displayDetails() {
        System.out.println("License: " + licensePlate + ", Owner: " + ownerName + ", Hours: " + hoursParked);
    }
}

class ParkingLot {
    private Vehicle[] vehicles = new Vehicle[5];
    private int count = 0;

    // Add vehicle
    public void parkVehicle(Vehicle vehicle) {
        if (count < 5) {
            vehicles[count] = vehicle;
            count++;
        } else {
            System.out.println("Parking lot is full.");
        }
    }

    // Remove vehicle by license plate
    public void removeVehicle(String licensePlate) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                // Shift remaining vehicles
                for (int j = i; j < count - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[count - 1] = null;
                count--;
                System.out.println("Vehicle with license " + licensePlate + " removed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with license " + licensePlate + " not found.");
        }
    }

    // Display all parked vehicles
    public void displayAllVehicles() {
        System.out.println("\nAll Parked Vehicles:");
        for (int i = 0; i < count; i++) {
            vehicles[i].displayDetails();
        }
    }
}

public class Vehicles {
    public static void main(String[] args) {
        // Create parking lot instance
        ParkingLot lot = new ParkingLot();

        // Park vehicles
        lot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        // Remove one vehicle
        lot.removeVehicle("XYZ789");

        // Display all parked vehicles
        lot.displayAllVehicles();
    }
}