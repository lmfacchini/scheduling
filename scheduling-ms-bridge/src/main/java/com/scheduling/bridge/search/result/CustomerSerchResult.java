package com.scheduling.bridge.search.result;

import com.scheduling.bridge.TransactionObject;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerSerchResult extends TransactionObject {

    private String name;

    private String document;


    public CustomerSerchResult(String id, String name, String document) {
        super(id);
        this.name = name;
        this.document = document;
    }
}
