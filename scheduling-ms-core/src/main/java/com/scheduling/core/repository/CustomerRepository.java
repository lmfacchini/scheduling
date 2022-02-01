package com.scheduling.core.repository;


import com.scheduling.domain.vo.CustomerVO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepository  extends MongoRepository<CustomerVO, ObjectId> {

    CustomerVO findByDocument(String document);
}
