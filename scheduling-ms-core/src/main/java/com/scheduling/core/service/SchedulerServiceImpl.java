package com.scheduling.core.service;

import com.scheduling.bridge.BusinessException;
import com.scheduling.bridge.search.SchedulerSearchData;
import com.scheduling.bridge.search.result.SchedulerSerchResult;
import com.scheduling.bridge.service.CustomerService;
import com.scheduling.bridge.service.SchedulerService;
import com.scheduling.bridge.service.WorkService;
import com.scheduling.bridge.to.CustomerTO;
import com.scheduling.bridge.to.SchedulerTO;
import com.scheduling.bridge.to.WorkTO;
import com.scheduling.core.AbstractCrudService;
import com.scheduling.core.repository.SchedulerRepository;
import com.scheduling.domain.vo.SchedulerVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class SchedulerServiceImpl extends AbstractCrudService<SchedulerTO, SchedulerSearchData, SchedulerSerchResult, SchedulerVO, SchedulerRepository> implements SchedulerService {


    public SchedulerServiceImpl(SchedulerRepository repository) {
        super(repository);
    }


    @Autowired
    private WorkService workService;

    @Autowired
    private CustomerService customerService;

    @Override
    public SchedulerTO create(SchedulerTO ẗo) {
        WorkTO work = workService.findByCode(ẗo.getCodeWork());
        if(work == null){
            throw new BusinessException("MB00000005");


        }

        CustomerTO customer = customerService.findByDocument(ẗo.getCustomerDocument());
        if(customer == null){
            throw new BusinessException("MB00000006");
        }

        return super.create(ẗo);
    }

    @Override
    public Collection<SchedulerSerchResult> list(SchedulerSearchData searchData) {
        SchedulerVO vo = new SchedulerVO();
        vo.setDateTime(searchData.getDateTime());
        vo.setCustomerDocument(searchData.getCustomerDocument());
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
        Example<SchedulerVO> example = Example.of(vo, matcher);

        Collection<SchedulerVO> result = repository.findAll(example, Sort.by("dateTime").descending());
        if(CollectionUtils.isEmpty(result)){

            return Collections.emptyList();
        }
        Collection<SchedulerSerchResult> data =  result.stream().collect(Collectors.groupingBy(SchedulerVO::getCustomerDocument, Collectors.groupingBy(s->s.getDateTime().toLocalDate(), Collectors.summingDouble(s->{
            WorkTO work = workService.findByCode(s.getCodeWork());
            return work.getValue().doubleValue();
        })))).entrySet().stream().map(r->new SchedulerSerchResult(r.getKey(), r.getValue())).collect(Collectors.toList());

        return data;


    }

    @Override
    protected SchedulerVO parse(SchedulerTO to) {
        SchedulerVO vo = new SchedulerVO();
        vo.setNote(to.getNote());
        vo.setCodeWork(to.getCodeWork());
        vo.setId(to.getId() == null ? null : new ObjectId(to.getId()));
        vo.setDateTime(to.getDateTime());
        vo.setCustomerDocument(to.getCustomerDocument());
        return vo;
    }

    @Override
    protected SchedulerTO parse(SchedulerVO vo) {
        SchedulerTO to = new SchedulerTO();
        to.setNote(vo.getNote());
        to.setCodeWork(vo.getCodeWork());
        to.setId(vo.getId() == null ? null : vo.getId().toHexString());
        to.setDateTime(vo.getDateTime());
        to.setCustomerDocument(vo.getCustomerDocument());
        return to;
    }
}
