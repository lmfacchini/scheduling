package com.scheduling.core.repository;

import com.scheduling.domain.vo.SchedulerVO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SchedulerRepository  extends MongoRepository<SchedulerVO, ObjectId> {

}
