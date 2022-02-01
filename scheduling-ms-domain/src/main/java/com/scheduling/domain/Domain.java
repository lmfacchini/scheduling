package com.scheduling.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public abstract class Domain {

    @Id
    private ObjectId id;
}
