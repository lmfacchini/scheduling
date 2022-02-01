package com.scheduling.bridge.service;

import com.scheduling.bridge.search.WorkSearchData;
import com.scheduling.bridge.search.result.WorkSearchResult;
import com.scheduling.bridge.to.WorkTO;

public interface WorkService extends CrudService<WorkTO, WorkSearchData, WorkSearchResult>{
    WorkTO findByCode(String codeWork);
}
