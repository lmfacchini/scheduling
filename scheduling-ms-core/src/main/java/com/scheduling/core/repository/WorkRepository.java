package com.scheduling.core.repository;

import com.scheduling.domain.vo.WorkVO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface WorkRepository extends MongoRepository<WorkVO, ObjectId> {

    WorkVO findByCode(String codeWork);
}
