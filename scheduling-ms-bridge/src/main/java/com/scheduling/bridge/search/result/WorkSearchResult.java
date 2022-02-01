package com.scheduling.bridge.search.result;

import com.scheduling.bridge.TransactionObject;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WorkSearchResult extends TransactionObject {


    private String code;


    private String description;


    private BigDecimal value;

    public WorkSearchResult(String id, String code, String description, BigDecimal value) {
        super(id);
        this.code = code;
        this.description = description;
        this.value = value;
    }
}
