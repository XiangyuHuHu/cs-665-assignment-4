package edu.bu.met.cs665.UtilizingLegacy;
/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/07/2023
 * File Name: NewSystem.java
 * Description: new systerm that can use Http
 */
public class NewSystem implements CustomerDataHttpInterface {

    @Override
    public void printCustomer(int data) {
        System.out.println("New Http: " + data);
    }

    @Override
    public void getCustomerHttp(int customerId) {
        System.out.println("customer dataID over http:  " + customerId);
    }
}