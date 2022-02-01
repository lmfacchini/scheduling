package com.scheduling.bridge.search.result;

import com.scheduling.bridge.TransactionObject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
public class SchedulerSerchResult extends TransactionObject {

    private String customer;

    private Map<LocalDate, Double> dates;

    public SchedulerSerchResult(String customer, Map<LocalDate, Double> dates) {
        this.customer = customer;
        this.dates = dates;
    }
}
