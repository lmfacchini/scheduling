package com.scheduling.bridge.service;

import com.scheduling.bridge.search.CustomerSearchData;
import com.scheduling.bridge.search.result.CustomerSerchResult;
import com.scheduling.bridge.to.CustomerTO;

public interface CustomerService extends CrudService<CustomerTO, CustomerSearchData, CustomerSerchResult>{
    CustomerTO findByDocument(String customerDocument);
}
