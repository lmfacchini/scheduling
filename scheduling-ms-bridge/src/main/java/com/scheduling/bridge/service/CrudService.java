package com.scheduling.bridge.service;

import com.scheduling.bridge.TransactionObject;

import java.util.Collection;

public interface CrudService<TO extends TransactionObject,SD, RS> {
    TO create(TO to);

    TO update(TO to);

    TO delete(String id);

    Collection<RS> list(SD searchData);
}
