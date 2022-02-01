package com.scheduling.domain.vo;


import com.scheduling.domain.Domain;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "customer")
public class CustomerVO extends Domain {

    @Field
    private String name;

    @Field
    private String document;
}
