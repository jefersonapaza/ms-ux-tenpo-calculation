package com.tempo.challenge.calculation_service.domain.model;

import java.math.BigDecimal;

/**
 * Author: Jeferson Apaza
 * Date: 2025-04-26
 * Role: Software Engineer
 * <p>
 * Domain entity representing a dynamic calculation between two amounts,
 * applying a configurable percentage as part of the business logic.
 */
public class Calculation {

    private BigDecimal num1;
    private BigDecimal num2;
    private BigDecimal percentage;
    private BigDecimal result;

    /**
     * Constructor to initialize the numbers and the percentage for the calculation.
     *
     * @param num1       The first number for the calculation.
     * @param num2       The second number for the calculation.
     * @param percentage The percentage to apply on the sum of num1 and num2.
     */
    public Calculation(BigDecimal num1, BigDecimal num2, BigDecimal percentage) {
        this.num1 = num1;
        this.num2 = num2;
        this.percentage = percentage;
    }

    public BigDecimal getNum1() {return num1;}
    public BigDecimal getNum2() {return num2;}
    public BigDecimal getPercentage() {return percentage;}
    public BigDecimal getResult() {return result;}


}
