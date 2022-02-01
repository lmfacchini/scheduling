package com.scheduling.ws.controller;

import com.scheduling.bridge.search.CustomerSearchData;
import com.scheduling.bridge.search.result.CustomerSerchResult;
import com.scheduling.bridge.service.CustomerService;
import com.scheduling.bridge.to.CustomerTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl extends DefaultCrudController<CustomerTO, CustomerSearchData, CustomerSerchResult, CustomerService>{

    public CustomerControllerImpl(CustomerService service) {
        super(service);
    }
}
