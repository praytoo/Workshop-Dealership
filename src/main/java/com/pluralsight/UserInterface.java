package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private final Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public void display() {
        init();
        int choice;
        do {
            displayMenu();
            System.out.println("Enter choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> System.out.println("Goodbye");
                default -> System.out.println("Invalid option");
            }
        } while (choice != 99);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    private void displayMenu() {
        System.out.println("""
                1 - Find vehicles within a price range
                2 - Find vehicles by make / model
                3 - Find vehicles by year range
                4 - Find vehicles by color
                5 - Find vehicles by mileage range
                6 - Find vehicles by type
                7 - List ALL vehicles
                8 - Add a vehicle
                9 - Remove a vehicle
                99 - Quit
                """);
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Try again: ");
            }
        }
    }

    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Try again: ");
            }
        }
    }

    public void processGetByPriceRequest() {
        System.out.println("Enter minimum price: ");
        double min = getDoubleInput();
        System.out.println("Enter maximum price: ");
        double max = getDoubleInput();

        ArrayList<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        displayVehicles(results);
    }

    public void processByMakeModelRequest() {
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(results);
    }

    public void processGetByYearRequest() {
        System.out.println("Enter minimum year: ");
        int min = getIntInput();
        System.out.println("Enter maximum year: ");
        int max = getIntInput();

        ArrayList<Vehicle> results = dealership.getVehiclesByYear(min, max);
        displayVehicles(results);
    }

    public void processGetByColorRequest() {
        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByColor(color);
        displayVehicles(results);
    }

    public void processGetByMileageRequest() {
        System.out.println("Enter minimum mileage: ");
        int min = getIntInput();
        System.out.println("Enter maximum mileage: ");
        int max = getIntInput();

        ArrayList<Vehicle> results = dealership.getVehiclesByMileage(min, max);
        displayVehicles(results);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type (Car/ Truck/SUV/ Van): ");
        String vehicleType = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByType(vehicleType);
        displayVehicles(results);
    }

    public void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> all = dealership.getAllVehicles();
        displayVehicles(all);
    }

    public void processAddVehicleRequest() {
        System.out.println("Adding a new vehicle: ");

        System.out.println("VIN: ");
        int vin = getIntInput();
        System.out.println("Year: ");
        int year = getIntInput();
        System.out.println("Make: ");
        String make = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        System.out.println("Type: ");
        String type = scanner.nextLine();
        System.out.println("Color: ");
        String color = scanner.nextLine();
        System.out.println("Mileage: ");
        int mileage = getIntInput();
        System.out.println("Price: ");
        double price = getDoubleInput();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color,mileage, price);
        dealership.addVehicle(newVehicle);

        new DealershipFileManager().saveDealership(dealership);

        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = getIntInput();

        Vehicle toRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                toRemove = v;
                break;
            }
        }

        if (toRemove != null) {
            dealership.removeVehicle(toRemove);
            new DealershipFileManager().saveDealership(dealership);
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found");
            return;
        }

        System.out.printf("%-6s %-6s %-10s %-10s %-8s %-8s %-10s %-10s%n",
                "VIN", "YEAR", "MAKE", "MODEL", "TYPE", "COLOR", "MILEAGE", "PRICE");
        System.out.println("------------------------------------------------------------------");
        for (Vehicle v : vehicles) {
            System.out.printf("%-6d %-6d %-10s %-10s %-8s %-8s %-10d $%-10.2f%n",
                    v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                    v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
        }
    }
}
