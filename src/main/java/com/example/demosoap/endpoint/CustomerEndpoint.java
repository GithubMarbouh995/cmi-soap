package com.example.demosoap.endpoint;

import com.example.demosoap.converter.CustomerConverter;
import com.example.demosoap.gen.*;
import com.example.demosoap.model.CustomerModel;
import com.example.demosoap.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CustomerEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomersRequest")
    @ResponsePayload
    public GetCustomersResponse getCustomers(@RequestPayload GetCustomersRequest request) {
        GetCustomersResponse response = new GetCustomersResponse();
        List<CustomerModel> customerModels = customerRepository.findAll();
        response.getCustomers().addAll(customerConverter.convertCustomerModelsToCustomers(customerModels));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
        GetCustomerResponse response = new GetCustomerResponse();
        CustomerModel customerModel = customerRepository.findByEmail(request.getEmail());
        response.setCustomer(customerConverter.convertCustomerModelToCustomer(customerModel));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCustomerRequest")
    @ResponsePayload
    public CreateCustomerResponse createCustomer(@RequestPayload CreateCustomerRequest request) {
        CreateCustomerResponse response = new CreateCustomerResponse();
        CustomerModel customerModel = customerConverter.convertCustomerToCustomerModel(request.getCustomer());
        CustomerModel savedCustomer = customerRepository.save(customerModel);
        response.setCustomer(customerConverter.convertCustomerModelToCustomer(savedCustomer));
        return response;
    }
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerByCinRequest")
  @ResponsePayload 
  public GetCustomerByCinResponse getCustomerByCin(@RequestPayload GetCustomerByCinRequest request) {
    GetCustomerByCinResponse response = new GetCustomerByCinResponse();
    CustomerModel customerModel = customerRepository.findByCin(request.getCin());
    response.setCustomer(customerConverter.convertCustomerModelToCustomer(customerModel));
    return response;
   }
}