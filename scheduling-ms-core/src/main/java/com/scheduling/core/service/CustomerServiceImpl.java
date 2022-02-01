package com.scheduling.core.service;

import com.scheduling.bridge.TransactionObject;
import com.scheduling.bridge.search.CustomerSearchData;
import com.scheduling.bridge.search.result.CustomerSerchResult;
import com.scheduling.bridge.service.CustomerService;
import com.scheduling.bridge.to.CustomerTO;
import com.scheduling.core.AbstractCrudService;
import com.scheduling.core.repository.CustomerRepository;
import com.scheduling.domain.vo.CustomerVO;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl extends AbstractCrudService<CustomerTO, CustomerSearchData, CustomerSerchResult, CustomerVO, CustomerRepository> implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public Collection<CustomerSerchResult> list(CustomerSearchData searchData) {

        CustomerVO vo = new CustomerVO();
        vo.setName(searchData.getName());
        vo.setDocument(searchData.getDocument());
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
        Example<CustomerVO> example = Example.of(vo, matcher);

        Collection<CustomerVO> result = repository.findAll(example);
        if(CollectionUtils.isEmpty(result)){

            return Collections.emptyList();
        }
        return result.stream().map(r->new CustomerSerchResult(r.getId().toHexString(), r.getName(), r.getDocument())).collect(Collectors.toList());
    }

    @Override
    protected CustomerVO parse(CustomerTO to) {
        CustomerVO vo = new CustomerVO();
        vo.setId(to.getId() == null ? null : new ObjectId(to.getId()));
        vo.setDocument(to.getDocument());
        vo.setName(to.getName());
        return vo;
    }

    @Override
    protected CustomerTO parse(CustomerVO vo) {
        CustomerTO to = new CustomerTO();
        to.setId(vo.getId() == null ? null : vo.getId().toHexString());
        to.setDocument(vo.getDocument());
        to.setName(vo.getName());
        return to;
    }

    @Override
    public CustomerTO findByDocument(String document) {
        CustomerVO vo = repository.findByDocument(document);
        return vo == null ? null : parse(vo);
    }
}
