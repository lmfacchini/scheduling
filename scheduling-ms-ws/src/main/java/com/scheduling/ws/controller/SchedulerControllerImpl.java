package com.scheduling.ws.controller;

import com.scheduling.bridge.search.SchedulerSearchData;
import com.scheduling.bridge.search.result.SchedulerSerchResult;
import com.scheduling.bridge.service.SchedulerService;
import com.scheduling.bridge.to.SchedulerTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerControllerImpl extends DefaultCrudController<SchedulerTO, SchedulerSearchData, SchedulerSerchResult, SchedulerService>{

    public SchedulerControllerImpl(SchedulerService service) {
        super(service);
    }
}
