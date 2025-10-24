package com.pluralsight;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.tree.VariableHeightLayoutCache;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    private Dealership dealership;

    @BeforeEach
    void init(){
        String name = "D & B Used Cars";
        String address = "111 Old Benbrook Rd";
        String phone = "817-555-5555";
        ArrayList<Vehicle> allVehicles = new ArrayList<>();

        dealership = new Dealership(name, address, phone, allVehicles);
    }
    @Test
    void getName() {
        //arrange
        String name = "D & B Used Cars";
        //act
        String result = dealership.getName();
        //assert
        assertEquals(name, result);
    }

    @Test
    void getAddress() {
        //arrange
        String address = "111 Old Benbrook Rd";
        //act
        String result = dealership.getAddress();
        //assert
        assertEquals(address, result);
    }

    @Test
    void getPhone() {
        //arrange
        String phone = "817-555-5555";
        //act
        String result = dealership.getPhone();
        //assert
        assertEquals(phone, result);
    }

    @Test
    void getAllVehicles() {
        //arrange
        Vehicle vehicle1 = new Vehicle(10112, 1993, "Ford", "Explorer", "SUV", "Red", 525123, 995.00);
        Vehicle vehicle2 = new Vehicle(37846, 2001, "Ford", "Ranger", "Truck", "Yellow", 172544, 1995.00);
        Vehicle vehicle3 = new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Grey", 103221, 6995.00);
        ArrayList<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.add(vehicle1);
        allVehicles.add(vehicle2);
        allVehicles.add(vehicle3);
        //act
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        //assert
        assertEquals(allVehicles, dealership.getAllVehicles());
    }

    @Test
    void addVehicle() {
        //arrange
        Vehicle vehicle1 = new Vehicle(10112, 1993, "Ford", "Explorer", "SUV", "Red", 525123, 995.00);
        ArrayList<Vehicle> inventory = new ArrayList<>();
        inventory.add(vehicle1);
        //act
        dealership.addVehicle(vehicle1);
        //assert
        assertEquals(inventory, dealership.getAllVehicles());
    }

    @Test
    void removeVehicle() {
        //arrange
        Vehicle vehicle2 = new Vehicle(37846, 2001, "Ford", "Ranger", "Truck", "Yellow", 172544, 1995.00);
        ArrayList<Vehicle> inventory = new ArrayList<>();
        inventory.remove(vehicle2);
        //act
        dealership.removeVehicle(vehicle2);
        //assert
        assertEquals(inventory, dealership.getAllVehicles());
    }

    @Test
    void getVehiclesByPrice() {
        //arrange
        Vehicle vehicle3 = new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Grey", 103221, 6995.00);
        ArrayList<Vehicle> inventory = new ArrayList<>();
        inventory.add(vehicle3);
        double minPrice = 6000.00;
        double maxPrice = 7000.00;
        //act
        dealership.addVehicle(vehicle3);
        //assert
        assertEquals(inventory, dealership.getVehiclesByPrice(minPrice, maxPrice));
    }

    @Test
    void getVehiclesByMakeModel() {
        //arrange
        Vehicle vehicle3 = new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Grey", 103221, 6995.00);
        ArrayList<Vehicle> inventory = new ArrayList<>();
        inventory.add(vehicle3);
        String make = "Honda";
        String model = "Civic";
        //act
        dealership.addVehicle(vehicle3);
        //assert
        assertEquals(inventory, dealership.getVehiclesByMakeModel(make, model));
    }

    @Test
    void getVehiclesByYear() {
        //arrange
        Vehicle vehicle3 = new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Grey", 103221, 6995.00);
        ArrayList<Vehicle> inventory = new ArrayList<>();
        inventory.add(vehicle3);
        int minYear = 2010;
        int maxYear = 2014;
        //act
        dealership.addVehicle(vehicle3);
        //assert
        assertEquals(inventory, dealership.getVehiclesByPrice(minYear, maxYear));
    }

    @Test
    void getVehiclesByColor() {
        //arrange
        Vehicle vehicle3 = new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Grey", 103221, 6995.00);
        ArrayList<Vehicle> inventory = new ArrayList<>();
        inventory.add(vehicle3);
        String color = "Grey";
        //act
        dealership.addVehicle(vehicle3);
        //assert
        assertEquals(inventory, dealership.getVehiclesByColor(color));
    }

    @Test
    void getVehiclesByMileage() {
        //arrange
        Vehicle vehicle3 = new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Grey", 103221, 6995.00);
        ArrayList<Vehicle> inventory = new ArrayList<>();
        inventory.add(vehicle3);
        int minMileage = 100000;
        int maxMileage = 150000;
        //act
        dealership.addVehicle(vehicle3);
        //assert
        assertEquals(inventory, dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    @Test
    void getVehiclesByType() {
        //arrange
        Vehicle vehicle3 = new Vehicle(44901, 2012, "Honda", "Civic", "SUV", "Grey", 103221, 6995.00);
        ArrayList<Vehicle> inventory = new ArrayList<>();
        inventory.add(vehicle3);
        String type = "SUV";
        //act
        dealership.addVehicle(vehicle3);
        //assert
        assertEquals(inventory, dealership.getVehiclesByType(type));
    }
}