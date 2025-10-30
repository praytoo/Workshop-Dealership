package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
                case 10 -> processSellLeaseVehicleRequest();
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
                10 - Sell/Lease a vehicle
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

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
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

    public void displayVehicles(ArrayList<Vehicle> vehicles) {
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
    public void processSellLeaseVehicleRequest() {
        System.out.println("Do you want to sell or lease a vehicle?");
        String sellOrLease = scanner.nextLine();
        double salesTax = 0;
        int recordingFee = 0;
        int processingFee = 0;
        boolean financeOption = false;
        String date = null;
        String name = null;
        String email = null;
        int vin = 0;
        int year = 0;
        String make = null;
        String model = null;
        String type = null;
        String color = null;
        int mileage = 0;
        double vehiclePrice = 0;
        double totalPrice = 0;
        double monthlyPayment = 0;
        SalesContract salesContract = new SalesContract();
        SalesContract salesContract1 = new SalesContract();
        if (sellOrLease.equalsIgnoreCase("sell")) {
            System.out.println("Enter the date: ");
            salesContract.setDateOfContract(scanner.nextLine());
            System.out.println("Enter your name: ");
            salesContract.setCustomerName(scanner.nextLine());
            System.out.println("Enter your email: ");
            salesContract.setCustomerEmail(scanner.nextLine());
            System.out.println("Enter vehicle VIN: ");
            salesContract.setVin(scanner.nextInt());
            System.out.println("Enter vehicle Year: ");
            salesContract.setYear(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter vehicle Make: ");
            salesContract.setMake(scanner.nextLine());
            System.out.println("Enter vehicle Model: ");
            salesContract.setModel(scanner.nextLine());
            System.out.println("Enter vehicle Type of Vehicle: ");
            salesContract.setVehicleType(scanner.nextLine());
            System.out.println("Enter vehicle Color: ");
            salesContract.setColor(scanner.nextLine());
            System.out.println("Enter vehicle Mileage: ");
            salesContract.setOdometer(scanner.nextInt());
            System.out.println("Enter how much you paid for the vehicle: ");
            salesContract.setVehiclePrice(scanner.nextDouble());
            System.out.println("Enter sales tax info (5% or .05): ");
            salesContract.setSalesTaxAmount(scanner.nextDouble());
            System.out.println("Enter recording fee amount ($100): ");
            salesContract.setRecordingFee(scanner.nextInt());
            System.out.println("Enter processing fee amount ($295 for vehicles under $10,000 and $495 for all others): ");
            salesContract.setProcessingFee(scanner.nextInt());
            System.out.println("Are you financing the vehicle? (true/false): ");
            salesContract.setFinanceOption(scanner.nextBoolean());
            scanner.nextLine();

            System.out.println(salesContract.getTotalPrice());
            System.out.println(salesContract.getMonthlyPayment());

            List<SalesContract> contracts = new ArrayList<>();
            contracts.add(salesContract);
            new ContractsFileManager().saveSalesContract(contracts);

            System.out.println("Vehicle sale added successfully!");
        } else {
            LeaseContract leaseContract = new LeaseContract();
            LeaseContract leaseContract1 = new LeaseContract();
            System.out.println("Enter the date: ");
            leaseContract.setDateOfContract(scanner.nextLine());
            System.out.println("Enter your name: ");
            leaseContract.setCustomerName(scanner.nextLine());
            System.out.println("Enter your email: ");
            leaseContract.setCustomerEmail(scanner.nextLine());
            System.out.println("Enter vehicle VIN: ");
            leaseContract.setVin(scanner.nextInt());
            System.out.println("Enter vehicle Year: ");
            leaseContract.setYear(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter vehicle Make: ");
            leaseContract.setMake(scanner.nextLine());
            System.out.println("Enter vehicle Model: ");
            leaseContract.setModel(scanner.nextLine());
            System.out.println("Enter vehicle Type of Vehicle: ");
            leaseContract.setVehicleType(scanner.nextLine());
            System.out.println("Enter vehicle Color: ");
            leaseContract.setColor(scanner.nextLine());
            System.out.println("Enter vehicle Mileage: ");
            leaseContract.setOdometer(scanner.nextInt());
            System.out.println("Enter how much you paid for the vehicle: ");
            leaseContract.setVehiclePrice(scanner.nextDouble());
            System.out.println("Enter the expected ending value (50% of original price): ");
            leaseContract.setExpectedEndingValue(scanner.nextDouble());
            System.out.println("Enter lease fee amount (7% of original price): ");
            leaseContract.setLeaseFee(scanner.nextDouble());
            scanner.nextLine();

            System.out.println(leaseContract.getTotalPrice());
            System.out.println(leaseContract.getMonthlyPayment());

            List<LeaseContract> contracts = new ArrayList<>();
            contracts.add(leaseContract);
            new ContractsFileManager().saveLeaseContract(contracts);

            System.out.println("Vehicle lease accepted!");
        }
    }
}
