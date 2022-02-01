package com.scheduling.domain.vo;

import com.scheduling.domain.Domain;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "scheduler")
public class SchedulerVO extends Domain {


    @Field
    private LocalDateTime dateTime;


    @Field
    private String note;


    @Field
    private String codeWork;


    @Field
    private String customerDocument;
}
