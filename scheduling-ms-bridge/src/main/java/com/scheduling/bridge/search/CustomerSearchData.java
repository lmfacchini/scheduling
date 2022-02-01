package com.scheduling.bridge.search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@ApiModel
public class CustomerSearchData {

    @ApiModelProperty(name = "name", dataType = "string")
    @Size(max = 150)
    private String name;

    @ApiModelProperty(name = "document", dataType = "string")
    @Size(max = 50)
    private String document;
}
