package edu.bu.met.cs665.UtilizingLegacy;
/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/07/2023
 * File Name: CustomerData.java
 * Description: Customer data interface, the new interface
 */

public class CustomerData {

    private CustomerDataUsbInterface usbInterface;

    public CustomerData(CustomerDataUsbInterface usbInterface) {
        this.usbInterface = usbInterface;
    }

    public void printCustomerData(int data) {
        usbInterface.printCustomer(data);
    }

    public void getCustomerData(int customerId) {
        usbInterface.getCustomerUsb(customerId);
    }
}