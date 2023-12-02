import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String carId;
    private String brand;
    private boolean available;

    public Car(String carId, String brand) {
        this.carId = carId;
        this.brand = brand;
        this.available = true;
    }

    public String getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        available = false;
    }

    public void returnCar() {
        available = true;
    }
}

class RentalSystem {
    private List<Car> cars;

    public RentalSystem() {
        cars = new ArrayList<>();
    }

    public void addCar(String carId, String brand) {
        cars.add(new Car(carId, brand));
    }

    public void rentCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                car.rent();
                System.out.println("Car rented successfully.");
                return;
            }
        }
        System.out.println("Car not available for rent.");
    }

    public void returnCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isAvailable()) {
                car.returnCar();
                System.out.println("Car returned successfully.");
                return;
            }
        }
        System.out.println("Invalid car ID or car is not rented.");
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println("Car ID: " + car.getCarId() + ", Brand: " + car.getBrand());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();
        rentalSystem.addCar("C001", "Toyota");
        rentalSystem.addCar("C002", "Honda");
        rentalSystem.addCar("C003", "Ford");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCar Rental System Menu:");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Display Available Cars");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Car ID to rent: ");
                    String rentCarId = scanner.next();
                    rentalSystem.rentCar(rentCarId);
                    break;

                case 2:
                    System.out.print("Enter Car ID to return: ");
                    String returnCarId = scanner.next();
                    rentalSystem.returnCar(returnCarId);
                    break;

                case 3:
                    rentalSystem.displayAvailableCars();
                    break;

                case 4:
                    System.out.println("Exiting Car Rental System. Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
