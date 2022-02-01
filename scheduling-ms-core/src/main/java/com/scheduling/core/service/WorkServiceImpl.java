package com.scheduling.core.service;

import com.scheduling.bridge.search.WorkSearchData;
import com.scheduling.bridge.search.result.CustomerSerchResult;
import com.scheduling.bridge.search.result.WorkSearchResult;
import com.scheduling.bridge.service.WorkService;
import com.scheduling.bridge.to.WorkTO;
import com.scheduling.core.AbstractCrudService;
import com.scheduling.core.repository.WorkRepository;
import com.scheduling.domain.vo.CustomerVO;
import com.scheduling.domain.vo.WorkVO;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class WorkServiceImpl extends AbstractCrudService<WorkTO, WorkSearchData, WorkSearchResult, WorkVO, WorkRepository> implements WorkService {

    public WorkServiceImpl(WorkRepository repository) {
        super(repository);
    }

    @Override
    public Collection<WorkSearchResult> list(WorkSearchData searchData) {
        WorkVO vo = new WorkVO();
        vo.setCode(searchData.getCode());
        vo.setValue(searchData.getValue());
        vo.setDescription(searchData.getDescription());
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
        Example<WorkVO> example = Example.of(vo, matcher);

        Collection<WorkVO> result = repository.findAll(example);

        if(CollectionUtils.isEmpty(result)){

            return Collections.emptyList();
        }

        return result.stream().map(r->new WorkSearchResult(r.getId().toHexString(), r.getCode(), r.getDescription(), r.getValue())).collect(Collectors.toList());
    }

    @Override
    public WorkTO findByCode(String codeWork) {
        WorkVO vo = repository.findByCode(codeWork);
        return vo == null ? null : parse(vo);
    }

    @Override
    protected WorkVO parse(WorkTO to) {
        WorkVO vo = new WorkVO();
        vo.setCode(to.getCode());
        vo.setDescription(to.getDescription());
        vo.setValue(to.getValue());
        vo.setId(to.getId() == null ? null : new ObjectId(to.getId()));
        return vo;
    }

    @Override
    protected WorkTO parse(WorkVO vo) {
        WorkTO to = new WorkTO();
        to.setCode(vo.getCode());
        to.setDescription(vo.getDescription());
        to.setValue(vo.getValue());
        to.setId(vo.getId() == null ? null : vo.getId().toHexString());
        return to;
    }
}
