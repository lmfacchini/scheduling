package com.scheduling.bridge.to;

import com.scheduling.bridge.TransactionObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ApiModel
public class CustomerTO extends TransactionObject {


    @ApiModelProperty(required = true, name = "name", dataType = "string")
    @NotBlank
    @Size(max = 150)
    private String name;

    @ApiModelProperty(required = true, name = "document", dataType = "string")
    @NotBlank
    @Size(max = 50)
    private String document;
}
