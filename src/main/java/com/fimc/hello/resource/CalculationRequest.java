package com.fimc.hello.resource;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationRequest implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 209566815784380412L;

    private String operator;
    private BigDecimal number1;
    private BigDecimal number2;

    public CalculationRequest(String operator, BigDecimal number1, BigDecimal number2) {
        this.operator = operator;
        this.number1 = number1;
        this.number2 = number2;
    }

}
