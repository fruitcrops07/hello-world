package com.fimc.hello.resource;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationResponse {

    private String action;
    private BigDecimal result;
}
