package com.scheduling.bridge.search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@ApiModel
public class WorkSearchData {

    @ApiModelProperty(name = "code", dataType = "string")
    @Size(max = 100)
    private String code;

    @ApiModelProperty(name = "description", dataType = "string")
    @Size(max = 150)
    private String description;

    @ApiModelProperty(name = "value", dataType = "float")
    private BigDecimal value;
}
