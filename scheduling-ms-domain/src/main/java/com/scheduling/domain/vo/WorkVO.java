package com.scheduling.domain.vo;

import com.scheduling.domain.Domain;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
@Document(collection = "service")
public class WorkVO extends Domain {

    @Field
    private String code;

    @Field
    private String description;

    @Field
    private BigDecimal value;
}
