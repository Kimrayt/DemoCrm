package com.example.crmdemo.Services;

import com.example.crmdemo.Model.Customer;
import com.example.crmdemo.Repository.CustomerRepository;
import com.example.crmdemo.Specifications.CustomerDatatableFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Page<Customer> getCustomersForDatatable(String queryString, Pageable pageable) {
        CustomerDatatableFilter customerDatatableFilter = new CustomerDatatableFilter(queryString);
        return customerRepository.findAll(customerDatatableFilter, pageable);
    }
}
