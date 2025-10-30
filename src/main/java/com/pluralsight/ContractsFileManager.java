package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractsFileManager {
    private static final String contractSale = "C:\\User\\Student\\pluralsight\\Workshop-Dealership\\contractsSale.csv";

    public ArrayList<SalesContract> getSalesContracts() {
        Contract contract = null;

        ArrayList<SalesContract> contracts = null;
        try (BufferedReader br = new BufferedReader(new FileReader(contractSale))) {
            contracts = new ArrayList<>();
            contract = new SalesContract();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
            }

            String[] saleContractInfo = line.split("\\|");
            String contractType = saleContractInfo[0];
            String dateOfContract = saleContractInfo[1];
            String customerName = saleContractInfo[2];
            String customerEmail = saleContractInfo[3];
            int vin = Integer.parseInt(saleContractInfo[4]);
            int year = Integer.parseInt(saleContractInfo[5]);
            String make = saleContractInfo[6];
            String model = saleContractInfo[7];
            String vehicleType = saleContractInfo[8];
            String color = saleContractInfo[9];
            int odometer = Integer.parseInt(saleContractInfo[10]);
            double vehiclePrice = Double.parseDouble(saleContractInfo[11]);
            double salesTax = Double.parseDouble(saleContractInfo[12]);
            int recordingFee = Integer.parseInt(saleContractInfo[13]);
            int processingFee = Integer.parseInt(saleContractInfo[14]);
            double totalPrice = Double.parseDouble(saleContractInfo[15]);
            boolean financeOption = Boolean.parseBoolean(saleContractInfo[16]);
            double monthlyPayment = Double.parseDouble(saleContractInfo[17]);

            Contract contract1 = new SalesContract();
            contract.add(contract1);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found → " + contractSale);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return contracts;
    }

    public void saveSalesContract(List<SalesContract> contracts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(contractSale))) {
            for (SalesContract s : contracts) {
                writer.println(s.getDateOfContract() + ", " +
                        s.getCustomerName() + ", " +
                        s.getCustomerEmail() + ", " +
                        s.getVin() + ", " +
                        s.getYear() + ", " +
                        s.getMake() + ", " +
                        s.getModel() + ", " +
                        s.getVehicleType() + ", " +
                        s.getColor() + ", " +
                        s.getOdometer() + ", " +
                        s.getVehiclePrice() + ", " +
                        s.getSalesTaxAmount() + ", " +
                        s.getRecordingFee() + ", " +
                        s.getProcessingFee() + ", " +
                        s.getTotalPrice() + ", " +
                        s.isFinanceOption() + ", " +
                        s.getMonthlyPayment());
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

    }
    private static final String contractLease = "C:\\User\\Student\\pluralsight\\Workshop-Dealership\\contractsLease.csv";

    public ArrayList<LeaseContract> getLeaseContracts() {
        Contract contract = null;

        ArrayList<LeaseContract> contracts = null;
        try (BufferedReader br = new BufferedReader(new FileReader(contractLease))) {
            contracts = new ArrayList<>();
            contract = new LeaseContract();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
            }

            String[] saleContractInfo = line.split("\\|");
            String contractType = saleContractInfo[0];
            String dateOfContract = saleContractInfo[1];
            String customerName = saleContractInfo[2];
            String customerEmail = saleContractInfo[3];
            int vin = Integer.parseInt(saleContractInfo[4]);
            int year = Integer.parseInt(saleContractInfo[5]);
            String make = saleContractInfo[6];
            String model = saleContractInfo[7];
            String vehicleType = saleContractInfo[8];
            String color = saleContractInfo[9];
            int odometer = Integer.parseInt(saleContractInfo[10]);
            double vehiclePrice = Double.parseDouble(saleContractInfo[11]);
            double expectedEndingValue = Double.parseDouble(saleContractInfo[12]);
            double leaseFee = Double.parseDouble(saleContractInfo[13]);
            double totalPrice = Double.parseDouble(saleContractInfo[14]);
            double monthlyPayment = Double.parseDouble(saleContractInfo[15]);

            Contract contract1 = new LeaseContract();
            contract.add(contract1);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found → " + contractLease);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return contracts;
    }

    public void saveLeaseContract(List<LeaseContract> contracts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(contractLease))) {
            for (LeaseContract l : contracts) {
                writer.println(l.getDateOfContract() + ", " +
                        l.getCustomerName() + ", " +
                        l.getCustomerEmail() + ", " +
                        l.getVin() + ", " +
                        l.getYear() + ", " +
                        l.getMake() + ", " +
                        l.getModel() + ", " +
                        l.getVehicleType() + ", " +
                        l.getColor() + ", " +
                        l.getOdometer() + ", " +
                        l.getVehiclePrice() + ", " +
                        l.getExpectedEndingValue() + ", " +
                        l.getLeaseFee() + ", " +
                        l.getTotalPrice() + ", " +
                        l.getMonthlyPayment());
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

    }
}
