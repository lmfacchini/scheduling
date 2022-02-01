package com.scheduling.bridge.to;

import com.scheduling.bridge.TransactionObject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@ApiModel
public class SchedulerTO extends TransactionObject {

    @ApiModelProperty(required = true, name = "dateTime", dataType = "Date", example = "2011-12-03T10:15:30")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @NotNull
    private LocalDateTime dateTime;

    @ApiModelProperty(name = "note", dataType = "string")
    @Size(max = 500)
    private String note;

    @ApiModelProperty(required = true, name = "codeWork", dataType = "string")
    @NotBlank
    @Size(max = 100)
    private String codeWork;


    @ApiModelProperty(required = true, name = "customerDocument", dataType = "string")
    @NotBlank
    @Size(max = 50)
    private String customerDocument;
}
