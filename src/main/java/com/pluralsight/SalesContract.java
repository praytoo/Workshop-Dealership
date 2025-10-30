package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean financeOption;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, String vehicleSold, int salesTaxAmount, int recordingFee, int processingFee, boolean financeOption) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    public SalesContract() {
        super();
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    public static void addSalesContract(String date, String customerName, String customerEmail, int vin, int year, String make, String model, String vehicleType, String color, int odometer, double vehiclePrice, double salesTax, int recordingFee, int processingFee, boolean financeOption, double totalPrice, double monthlyPayment){
    }

    @Override
    public double getTotalPrice() {
        if (totalPrice < 10000) {
            return totalPrice += 295;
        } else if (totalPrice >= 10000) {
            return totalPrice += 495;
        }
            if (!financeOption) {
                return totalPrice;
            }else if (financeOption && totalPrice >= 10000) {
                return totalPrice *= 1.0425;
            } else if (financeOption && totalPrice < 10000) {
                return totalPrice *= 1.0525;
            }
            return 0;
        }

    @Override
    public double getMonthlyPayment() {
        if (!financeOption) {
            monthlyPayment = 0;
        } else if (totalPrice >= 10000) {
            monthlyPayment = (0.425 * totalPrice) / 48;
        } else if (totalPrice < 10000) {
            monthlyPayment = (0.525 * totalPrice) / 24;
        }
        return monthlyPayment;
    }
}
