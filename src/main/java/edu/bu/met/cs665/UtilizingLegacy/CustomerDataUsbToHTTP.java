package edu.bu.met.cs665.UtilizingLegacy;
/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/07/2023
 * File Name: CustomerDataUsbToHTTP.java
 * Description: an adapter allowed two interface work together
 */
public class CustomerDataUsbToHTTP implements CustomerDataUsbInterface {

    private CustomerDataHttpInterface httpInterface;

    public CustomerDataUsbToHTTP(CustomerDataHttpInterface httpInterface) {
        this.httpInterface = httpInterface;
    }

    @Override
    public void printCustomer(int data) {
        httpInterface.printCustomer(data);
    }

    @Override
    public void getCustomerUsb(int customerId) {
        httpInterface.getCustomerHttp(customerId);
    }
}