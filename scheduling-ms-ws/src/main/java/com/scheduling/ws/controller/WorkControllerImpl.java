package com.scheduling.ws.controller;

import com.scheduling.bridge.search.WorkSearchData;
import com.scheduling.bridge.search.result.WorkSearchResult;
import com.scheduling.bridge.service.WorkService;
import com.scheduling.bridge.to.WorkTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class WorkControllerImpl extends DefaultCrudController<WorkTO, WorkSearchData, WorkSearchResult, WorkService>{

    public WorkControllerImpl(WorkService service) {
        super(service);
    }
}
