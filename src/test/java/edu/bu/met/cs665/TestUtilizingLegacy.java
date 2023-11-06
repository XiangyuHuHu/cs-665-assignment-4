package edu.bu.met.cs665;
import edu.bu.met.cs665.UtilizingLegacy.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUtilizingLegacy {
    class TestCustomerDataHttpInterface implements CustomerDataHttpInterface {
        int lastDataPrinted = -1;
        int lastCustomerIdRequested = -1;

        @Override
        public void printCustomer(int data) {
            lastDataPrinted = data;
        }
        @Override
        public void getCustomerHttp(int customerId) {
            lastCustomerIdRequested = customerId;
        }
    }
    class TestCustomerDataUsbInterface implements CustomerDataUsbInterface {
        int lastDataPrinted = -1;
        int lastCustomerIdRequested = -1;

        @Override
        public void printCustomer(int data) {
            lastDataPrinted = data;
        }

        @Override
        public void getCustomerUsb(int customerId) {
            lastCustomerIdRequested = customerId;
        }
    }
    @Test
    public void testCustomerDataWithUsbInterface() {
        TestCustomerDataUsbInterface testUsbInterface = new TestCustomerDataUsbInterface();
        CustomerData customerData = new CustomerData(testUsbInterface);

        customerData.printCustomerData(123);
        assertEquals(123, testUsbInterface.lastDataPrinted);

        customerData.getCustomerData(456);
        assertEquals(456, testUsbInterface.lastCustomerIdRequested);
    }
    @Test
    public void testCustomerDataUsbToHTTP() {
        TestCustomerDataHttpInterface testHttpInterface = new TestCustomerDataHttpInterface();
        CustomerDataUsbToHTTP adapter = new CustomerDataUsbToHTTP(testHttpInterface);

        adapter.printCustomer(789);
        assertEquals(789, testHttpInterface.lastDataPrinted);

        adapter.getCustomerUsb(101112);
        assertEquals(101112, testHttpInterface.lastCustomerIdRequested);
    }
    class ObservableNewSystem extends NewSystem {
        private int lastHandledCustomerId = -1;

        @Override
        public void printCustomer(int data) {
            super.printCustomer(data);
            lastHandledCustomerId = data; // In a real-world scenario, some state change would occur here.
        }

        @Override
        public void getCustomerHttp(int customerId) {
            super.getCustomerHttp(customerId);
            lastHandledCustomerId = customerId; // In a real-world scenario, some state change would occur here.
        }

        public int getLastHandledCustomerId() {
            return lastHandledCustomerId;
        }
    }

    @Test
    public void testCustomerDataUsbToHTTPOperation() {
        ObservableNewSystem observableSystem = new ObservableNewSystem();
        CustomerDataUsbToHTTP adapter = new CustomerDataUsbToHTTP(observableSystem);

        int testCustomerId = 999;
        adapter.getCustomerUsb(testCustomerId);
        assertEquals(testCustomerId, observableSystem.getLastHandledCustomerId());
    }

}
