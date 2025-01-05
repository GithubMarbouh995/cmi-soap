package com.example.demosoap.converter;

import com.example.demosoap.gen.Customer;
import com.example.demosoap.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerConverter {

    @Autowired
    private AccountConverter accountConverter;

    public CustomerModel convertCustomerToCustomerModel(Customer customer) {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customer.getId());
        customerModel.setFirstName(customer.getFirstName());
        customerModel.setLastName(customer.getLastName());
        customerModel.setEmail(customer.getEmail());
        customerModel.setPhone(customer.getPhone());
        customerModel.setAddress(customer.getAddress());
        customerModel.setCin(customer.getCin());
        return customerModel;
    }

    public Customer convertCustomerModelToCustomer(CustomerModel customerModel) {
        if (customerModel == null) return null;
        
        Customer customer = new Customer();
        customer.setId(customerModel.getId());
        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());
        customer.setEmail(customerModel.getEmail());
        customer.setPhone(customerModel.getPhone());
        customer.setAddress(customerModel.getAddress());
        customer.setCin(customerModel.getCin());
        
        if (customerModel.getAccounts() != null) {
            customer.getAccounts().addAll(
                accountConverter.convertAccountModelsToAccounts(customerModel.getAccounts())
            );
        }
        
        return customer;
    }

    public List<CustomerModel> convertCustomersToCustomerModels(List<Customer> customers) {
        List<CustomerModel> customerModels = new ArrayList<>();
        for (Customer customer : customers) {
            customerModels.add(convertCustomerToCustomerModel(customer));
        }
        return customerModels;
    }

    public List<Customer> convertCustomerModelsToCustomers(List<CustomerModel> customerModels) {
        List<Customer> customers = new ArrayList<>();
        for (CustomerModel customerModel : customerModels) {
            customers.add(convertCustomerModelToCustomer(customerModel));
        }
        return customers;
    }
}