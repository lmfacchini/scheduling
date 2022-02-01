package com.scheduling.bridge.to;

import com.scheduling.bridge.TransactionObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@ApiModel
public class WorkTO extends TransactionObject {

    @ApiModelProperty(required = true, name = "code", dataType = "string")
    @NotBlank
    @Size(max = 100)
    private String code;

    @ApiModelProperty(required = true, name = "description", dataType = "string")
    @Size(max = 150)
    private String description;

    @ApiModelProperty(required = true, name = "value", dataType = "float")
    @NotNull
    private BigDecimal value;
}
