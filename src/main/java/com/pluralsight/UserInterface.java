package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {}

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

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
            }
        } while (choice != 99);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    private void displayMenu(){
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
    public void processGetByPriceRequest() {}

    public void processByMakeModelRequest() {}

    public void processGetByYearRequest() {}

    public void processGetByColorRequest () {}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest() {}

    public void processGetAllVehiclesRequest() {}

    public void processAddVehicleRequest() {}

    public void processRemoveVehicleRequest() {}

    private void displayVehicles(ArrayList<Vehicle> vehicles) { }
}
