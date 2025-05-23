package com.tempo.challenge.calculation_service.domain.model;

import com.tempo.challenge.calculation_service.domain.exception.InvalidPercentageException;

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

    /**
     * Calculates the sum of num1 and num2 and then applies the dynamic percentage.
     * The result is stored in the 'result' attribute.
     */
    public void calculateResult() {

        if (percentage.compareTo(BigDecimal.ZERO) < 0 || percentage.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new InvalidPercentageException("Percentage must be between 0 and 100");
        }

        // Sum the two numbers
        BigDecimal sum = num1.add(num2);

        // Calculate the percentage to be applied to the sum
        BigDecimal percentageAmount = sum.multiply(percentage).divide(BigDecimal.valueOf(100));

        // Calculate final result
        result = sum.add(percentageAmount);
    }

    /**
     * Gets the result of the calculation.
     *
     * @return The result of (num1 + num2) + (percentage of the sum).
     */
    public BigDecimal getResult() {
        return result;
    }
}
