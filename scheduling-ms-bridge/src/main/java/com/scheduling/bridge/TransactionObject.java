package com.scheduling.bridge;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TransactionObject {

    private String id;

    public TransactionObject() {
    }

    public TransactionObject(String id) {
        this.id = id;
    }
}
