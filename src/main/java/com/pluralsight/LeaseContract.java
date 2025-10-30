package com.pluralsight;

public class LeaseContract extends Contract{
    private double vehiclePrice;
    private double expectedEndingValue;
    private double leaseFee;

    @Override
    public double getVehiclePrice() {
        return vehiclePrice;
    }

    @Override
    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public static void addLeaseContract(String date, String customerName, String customerEmail, int vin, int year, String make, String model, String vehicleType, String color, int odometer, double vehiclePrice, double expectedEndingValue, double leaseFee, double totalPrice, double monthlyPayment){
    }

    @Override
    public double getTotalPrice() {
        totalPrice = (vehiclePrice / 2) + (vehiclePrice * 0.07);
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        monthlyPayment = (1.04 * totalPrice) / 36;
        return monthlyPayment;
    }
}
