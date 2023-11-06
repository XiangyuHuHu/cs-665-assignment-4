package edu.bu.met.cs665.UtilizingLegacy;
/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/07/2023
 * File Name: Main.java
 * Description: Some test in main
 */
public class Main {
    public static void main(String[] args) {
        CustomerDataHttpInterface httpInterface = new NewSystem();
        CustomerDataUsbInterface adapter = new CustomerDataUsbToHTTP(httpInterface);
        CustomerData service = new CustomerData(adapter);
        int customerId = 123;
        service.getCustomerData(customerId);
        service.printCustomerData(456);
    }

}
