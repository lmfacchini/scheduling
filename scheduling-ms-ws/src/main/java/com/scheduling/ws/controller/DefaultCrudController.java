package com.scheduling.ws.controller;

import com.scheduling.bridge.TransactionObject;
import com.scheduling.bridge.controller.CrudController;
import com.scheduling.bridge.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public abstract class DefaultCrudController<TO extends TransactionObject,SD, RS, CS extends CrudService<TO,SD, RS>> implements CrudController<TO,SD, RS> {


    private CS service;

    protected DefaultCrudController(CS service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<TO> create(TO to) {
        to = service.create(to);
        return ResponseEntity.ok(to);
    }

    @Override
    public ResponseEntity<TO> update(TO to) {
        to = service.update(to);
        return ResponseEntity.ok(to);
    }

    @Override
    public ResponseEntity<TO> delete(String id) {
        TO to = service.delete(id);
        return ResponseEntity.ok(to);
    }

    @Override
    public ResponseEntity<Collection<RS>> list(SD searchData) {
        Collection<RS> tos = service.list(searchData);
        if(CollectionUtils.isEmpty(tos)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tos);

    }
}
