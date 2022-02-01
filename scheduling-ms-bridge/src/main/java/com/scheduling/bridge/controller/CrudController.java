package com.scheduling.bridge.controller;

import com.scheduling.bridge.TransactionObject;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public interface CrudController<TO extends TransactionObject, SD, RS> {

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Data created."),
            @ApiResponse(code = 400, message = "Business error."),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @PostMapping("/create")
    ResponseEntity<TO> create(@RequestBody TO to);


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Data updated."),
            @ApiResponse(code = 400, message = "Data not found or business error."),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @PostMapping("/update")
    ResponseEntity<TO> update(@RequestBody  TO to);



    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Data deleted."),
            @ApiResponse(code = 400, message = "Data not found or business error."),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @DeleteMapping("/{id}/delete")
    ResponseEntity<TO> delete(@ApiParam(name = "id", required = true) @PathVariable("id")  String id);


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Some data found."),
            @ApiResponse(code = 204, message = "Data empty."),
            @ApiResponse(code = 400, message = "Business error or parameter invalids."),
            @ApiResponse(code = 500, message = "Exception."),
    })
    @GetMapping
    ResponseEntity<Collection<RS>> list(@Validated SD searchData);

}
